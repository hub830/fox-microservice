package top.lemna.account.persistence.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lemna.account.exception.TradeNotExistException;
import top.lemna.account.persistence.entity.Trade;
import top.lemna.account.persistence.repository.TradeRepository;
import top.lemna.account.persistence.service.base.BaseService;
import top.lemna.core.enums.account.BillStatus;
import top.lemna.core.enums.account.BillType;

/**
 * 订单管理.
 * 
 * @author hu
 * 
 */
@Service
public class TradeService extends BaseService<Trade> {

  @Autowired
  private TradeRepository repository;

  public TradeService() {
    super();
  }


  /**
   * 根据账户ID及订单号交易类型查询交易
   * 
   * @param accountId
   * @param orderNo
   * @param type
   * @return
   */
  Trade findTodo(Long id, BillType type) {
    Optional<Trade> trade = repository.findByIdAndTypeAndStatus(id, type, BillStatus.PAYMENT);
    return trade.orElseThrow(() -> new TradeNotExistException(id, type, BillStatus.PAYMENT));
  }

  /**
   * 创建支付订单
   * 
   * @param accountId
   * @param tradeName
   * @param orderNo
   * @param income
   * @param outlay
   * @param type
   * @return
   */
  Trade create(Long accountId, String tradeName, Long income, Long outlay, BillType type) {

    Trade t = new Trade(accountId, tradeName, income, outlay, type);
    return save(t);
  }



  /**
   * 取消支付
   * 
   * @param accountId
   * @param orderNo
   * @param type
   */
  Trade cancel(Long tradeId, BillType type) {

    Trade trade = findTodo(tradeId, type);

    trade.setStatus(BillStatus.REFUND);
    return save(trade);
  }

  /**
   * 交易成功
   * 
   * @param accountId
   * @param orderNo
   * @param type
   */
  Trade success(Long tradeId, BillType type) {

    Trade trade = findTodo(tradeId, type);

    trade.setStatus(BillStatus.SUCCESS);
    return save(trade);

  }
}
