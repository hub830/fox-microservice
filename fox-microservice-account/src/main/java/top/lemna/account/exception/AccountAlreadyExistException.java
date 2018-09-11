package top.lemna.account.exception;

import java.text.MessageFormat;

public class AccountAlreadyExistException extends RuntimeException {
  private static final long serialVersionUID = 5770390658812498742L;

  public AccountAlreadyExistException(String accountName) {
    super(format(accountName));
  }


  static String format(String accountName) {

    return MessageFormat.format("名称为[{0}]的账号在数据中已经存在", //
        accountName);
  }
}
