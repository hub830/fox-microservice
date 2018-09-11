package top.lemna.account.persistence.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lemna.account.exception.AccountAlreadyExistException;
import top.lemna.account.exception.AccountBalanceNotEnoughException;
import top.lemna.account.persistence.entity.Account;
import top.lemna.account.persistence.repository.AccountRepository;
import top.lemna.account.persistence.service.base.BaseService;
import top.lemna.core.persistence.exception.RecordNotExistException;

/**
 * 账户管理.
 * 
 * @author hu
 * 
 */
@Service
public class AccountService extends BaseService<Account> {

  @Autowired
  private AccountRepository repository;

  @Autowired
  private AvailableBalanceLogService balanceService;

  @Autowired
  private FreezeBalanceLogService freezeService;

  public AccountService() {
    super();
  }



  private Account findByIdForUpdate(Long accountId) {
    Optional<Account> t = repository.findByIdForUpdate(accountId);
    return t.orElseThrow(() -> new RecordNotExistException(accountId));
  }

  /**
   * 创建新账户
   * 
   * @param accountName
   * @param type
   * @return
   */
  @Transactional
  public Account create(String accountName) {
    Optional<Account> optional = repository.findByAccountName(accountName);
    if(optional.isPresent())
    {
      throw new AccountAlreadyExistException(accountName);
    }
    
    Account account = new Account(accountName);
    return save(account);
  }


  /**
   * 贷记操作 收款 账户余额增加
   * 
   * @param accountId
   * @param amount
   */
  @Transactional
  void credit(Long accountId, Long amount, Long orderId, String remark) {
    Account account = findByIdForUpdate(accountId);


    Long beforeBalance = account.getAvailableBalance();
    account.setAvailableBalance(beforeBalance + amount);
    Long afterBalance = account.getAvailableBalance();
    // 创建交易 流水
    balanceService.create(accountId, orderId, beforeBalance, afterBalance, remark);

    save(account);
  }



  /**
   * 借记操作 付款 账户余额减少
   * 
   * @param accountId
   * @param amount
   */
  @Transactional
  void debit(Long accountId, Long amount, Long orderId, String remark) {
    Account account = findByIdForUpdate(accountId);
    if (account.getAvailableBalance() < amount) {
      throw new AccountBalanceNotEnoughException(account, amount);
    }
    Long beforeBalance = account.getAvailableBalance();
    account.setAvailableBalance(beforeBalance - amount);
    Long afterBalance = account.getAvailableBalance();
    // 创建交易 流水
    balanceService.create(accountId, orderId, beforeBalance, afterBalance, remark);
    save(account);
  }


  /**
   * 冻结
   * 
   * @param accountId
   * @param amount
   */
  @Transactional
  void frezze(Long accountId, Long amount, Long orderId, String remark) {
    Account account = findByIdForUpdate(accountId);

    Long beforeBalance = account.getFreezeBalance();
    account.setFreezeBalance(beforeBalance + amount);
    Long afterBalance = account.getFreezeBalance();
    // 创建交易 流水
    freezeService.create(accountId, orderId, beforeBalance, afterBalance, remark);
    
    save(account);
  }

  /**
   * 解冻
   * 
   * @param accountId
   * @param amount
   */
  @Transactional
  void unfreeze(Long accountId, Long amount, Long orderId, String remark) {
    Account account = findByIdForUpdate(accountId);
    if (account.getFreezeBalance() < amount) {
      throw new AccountBalanceNotEnoughException(account, amount);
    }

    Long beforeBalance = account.getFreezeBalance();
    account.setFreezeBalance(beforeBalance - amount);
    Long afterBalance = account.getFreezeBalance();
    // 创建交易 流水
    freezeService.create(accountId, orderId, beforeBalance, afterBalance, remark);
    
    save(account);
  }
}
