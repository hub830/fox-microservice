package top.lemna.account.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lemna.account.persistence.entity.FreezeBalanceLog;
import top.lemna.account.persistence.repository.FreezeBalanceLogRepository;
import top.lemna.account.persistence.service.base.BaseService;

/**
 * 冻结余额明细.
 * 
 * @author hu
 * 
 */
@Service
public class FreezeBalanceLogService extends BaseService<FreezeBalanceLog> {

  @Autowired
  @SuppressWarnings("unused")
  private FreezeBalanceLogRepository repository;

  public FreezeBalanceLogService() {
    super();
  }

  public FreezeBalanceLog create(Long accountId, Long orderId, Long beforeBalance,
      Long afterBalance, String remark) {
    FreezeBalanceLog bill =
        new FreezeBalanceLog(accountId, orderId, beforeBalance, afterBalance, remark);
    return save(bill);
  }

}
