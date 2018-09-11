package top.lemna.account.exception;

import java.text.MessageFormat;

import top.lemna.account.persistence.entity.Account;

public class AccountBalanceNotEnoughException extends RuntimeException {
  private static final long serialVersionUID = 5770390658812498742L;

  public AccountBalanceNotEnoughException(Account account, Long amount) {
    super(format(account, amount));
  }


  static String format(Account account, Long amount) {

    return MessageFormat.format("指定的账户[{0}]账户Id[{1}]余额[{2}]或冻结余额[{3}]不足[{4}]", //
        account.getAccountName(), //
        account.getId(), //
        account.getAvailableBalance(), //
        account.getFreezeBalance(), //
        amount);
  }
}
