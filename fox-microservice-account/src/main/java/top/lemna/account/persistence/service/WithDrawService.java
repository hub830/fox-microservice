package top.lemna.account.persistence.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lemna.account.persistence.entity.Trade;
import top.lemna.account.persistence.entity.WithDraw;
import top.lemna.account.persistence.repository.WithDrawRepository;
import top.lemna.account.persistence.service.base.BaseService;
import top.lemna.core.enums.account.BillType;
import top.lemna.core.enums.account.WithDrawType;

/**
 * 提现管理.
 * 
 * @author hu
 * 
 */
@Service
public class WithDrawService extends BaseService<WithDraw> {

  @SuppressWarnings("unused")
  @Autowired
  private WithDrawRepository repository;

  @Autowired
  private TradeService tradeService;

  @Autowired
  private AccountService accountService;

  public WithDrawService() {
    super();
  }


  private WithDraw create(Long accountId, Long amount, WithDrawType type, String remark,
      Trade trade) {
    WithDraw withDraw = new WithDraw(accountId, amount, type, remark, trade);
    return save(withDraw);
  }

  @Transactional
  public WithDraw place(Long accountId, Long amount, WithDrawType type, String remark) {
    Trade trade = tradeService.create(accountId, remark, 0L, amount, BillType.WITHDRAW_CASH);
    WithDraw withDraw = create(accountId, amount, type, remark, trade);

    // 将用户账户可用余额扣减，并增加冻结余额
    accountService.frezze(accountId, amount, trade.getId(), remark);
    accountService.debit(accountId, amount, trade.getId(), remark);
    return withDraw;
  }

  @Transactional
  public void cancel(Long id) {
    WithDraw withDraw = findById(id);
    Trade trade =
        tradeService.cancel(withDraw.getTrade().getId(), BillType.WITHDRAW_CASH);

    String remark = trade.getRemark() + " 提现退款";
    // 将用户账户可用余额增加，并扣减冻结余额
    accountService.credit(trade.getAccountId(), trade.getOutlay(), trade.getId(), remark);
    accountService.unfreeze(trade.getAccountId(), trade.getOutlay(), trade.getId(), remark);

  }

  @Transactional
  public void success(Long id) {
    WithDraw withDraw = findById(id);
    Trade trade =
        tradeService.success(withDraw.getTrade().getId(), BillType.WITHDRAW_CASH);

    // 将用户账户冻结余额扣减
    accountService.unfreeze(trade.getAccountId(), trade.getOutlay(), trade.getId(),
        trade.getRemark() + " 提现成功");

  }

}
