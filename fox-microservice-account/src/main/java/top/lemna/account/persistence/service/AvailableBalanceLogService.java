package top.lemna.account.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lemna.account.persistence.entity.AvailableBalanceLog;
import top.lemna.account.persistence.repository.AvailableBalanceLogRepository;
import top.lemna.account.persistence.service.base.BaseService;

/**
 * 可用余额交易明细.
 * 
 * @author hu
 * 
 */
@Service
public class AvailableBalanceLogService extends BaseService<AvailableBalanceLog> {

    @Autowired
    @SuppressWarnings("unused")
    private AvailableBalanceLogRepository repository;

    public AvailableBalanceLogService() {
        super();
    }

    public AvailableBalanceLog create(Long accountId, Long orderId, Long beforeBalance, Long afterBalance,String remark) {
        AvailableBalanceLog bill = new AvailableBalanceLog(accountId, orderId, beforeBalance, afterBalance,remark);
        return save(bill);
    }

    
}
