package top.lemna.account.persistence.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lemna.account.exception.RechargNotExistException;
import top.lemna.account.persistence.entity.Recharg;
import top.lemna.account.persistence.entity.Trade;
import top.lemna.account.persistence.repository.RechargRepository;
import top.lemna.account.persistence.service.base.BaseService;
import top.lemna.core.enums.account.BillType;
import top.lemna.core.enums.account.RechargerType;

/**
 * 充值管理.
 * 
 * @author hu
 * 
 */
@Service
public class RechargService extends BaseService<Recharg> {

  @SuppressWarnings("unused")
  @Autowired
  private RechargRepository repository;

  @Autowired
  private TradeService tradeService;

  @Autowired
  private AccountService accountService;

  public RechargService() {
    super();
  }

  private Recharg create(Long accountId, Long amount, RechargerType type, String remark,
      Trade trade) {
    Recharg recharg = new Recharg(accountId, amount, type, remark, trade);
    return save(recharg);
  }

  @Transactional
  public Recharg place(Long accountId, Long amount, RechargerType type, String remark) {
    accountService.findById(accountId);// 仅仅为检测账号是否存在，如果 不存在调用该方法时会报账号不存异常
    Trade trade = tradeService.create(accountId, remark, amount, 0L, BillType.RECHARGE);
    Recharg recharg = create(accountId, amount, type, remark, trade);

    return recharg;
  }

  @Transactional
  public void cancel(Long id, Long accountId) {

    Recharg recharg = findByIdAndAccountId(id, accountId);
    tradeService.cancel(recharg.getTrade().getId(), BillType.RECHARGE);

  }

  private Recharg findByIdAndAccountId(Long id, Long accountId) {
    Optional<Recharg> optional = repository.findByIdAndAccountId(id, accountId);
    return optional.orElseThrow(() -> new RechargNotExistException(id, accountId));
  }

  @Transactional
  public void success(Long id, Long accountId) {
    Recharg recharg = findByIdAndAccountId(id, accountId);
    Trade trade = tradeService.success(recharg.getTrade().getId(), BillType.RECHARGE);

    // 将用户账户可用余额增加
    accountService.credit(trade.getAccountId(), trade.getIncome(), trade.getId(),
        trade.getRemark() + "充值");
  }

}
