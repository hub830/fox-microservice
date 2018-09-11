package top.lemna.account.persistence.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lemna.account.exception.OrderAlreadyExistException;
import top.lemna.account.exception.OrderNotExistException;
import top.lemna.account.persistence.entity.Order;
import top.lemna.account.persistence.entity.Trade;
import top.lemna.account.persistence.repository.OrderRepository;
import top.lemna.account.persistence.service.base.BaseService;
import top.lemna.core.enums.account.BillType;

/**
 * 订单管理.
 * 
 * @author hu
 * 
 */
@Service
public class OrderService extends BaseService<Order> {

  @Autowired
  private OrderRepository repository;

  @Autowired
  private TradeService tradeService;

  @Autowired
  private AccountService accountService;

  public OrderService() {
    super();
  }

  /**
   * 根据 账户ID及商户订单号查找支付订单
   * 
   * @param accountId 账户ID
   * @param orderNo 商户订单号
   * @return
   */
  public Order find(Long accountId, String orderNo) {
    Order order = repository.findByAccountIdAndMerchantOrderNo(accountId, orderNo);
    if (order == null) {
      throw new OrderNotExistException(accountId, orderNo);
    }
    return order;
  }

  /**
   * 创建支付订单
   * 
   * @param account
   * @param orderNo 商户订单号
   * @param amount 交易发生额 单位为 分
   * @param remark 备注
   * @return
   */
  @Transactional
  private Order create(Long accountId, String orderNo, Long amount, String remark, Trade trade) {

    Order order = repository.findByAccountIdAndMerchantOrderNo(accountId, orderNo);
    if (order != null) {
      throw new OrderAlreadyExistException(accountId, orderNo);
    }

    order = new Order(accountId, orderNo, amount, remark, trade);
    return save(order);
  }

  @Transactional
  public Order place(Long accountId, String orderNo, Long amount, String remark) {
    Trade trade = tradeService.create(accountId, remark, 0L, amount, BillType.PAYMENT);
    Order order = create(accountId, orderNo, amount, remark, trade);
    // 将用户账户可用余额扣减，并增加冻结余额
    accountService.frezze(accountId, amount, trade.getId(), remark);
    accountService.debit(accountId, amount, trade.getId(), remark);
    return order;
  }

  @Transactional
  public void cancel(Long accountId, String orderNo) {
    Order order = find(accountId, orderNo);
    Trade trade = tradeService.cancel( order.getTrade().getId(), BillType.PAYMENT);
    String remark = trade.getRemark() + " 交易取消";
    // 将用户账户可用余额增加，并扣减冻结余额
    accountService.credit(accountId, trade.getOutlay(), trade.getId(), remark);
    accountService.unfreeze(accountId, trade.getOutlay(), trade.getId(), remark);
  }

  @Transactional
  public void success(Long accountId, String orderNo) {
    Order order = find(accountId, orderNo);
    Trade trade = tradeService.success(order.getTrade().getId(), BillType.PAYMENT);
    // 将用户账户冻结余额扣减
    accountService.unfreeze(accountId, trade.getOutlay(), trade.getId(),
        trade.getRemark() + " 交易成功");
  }
}
