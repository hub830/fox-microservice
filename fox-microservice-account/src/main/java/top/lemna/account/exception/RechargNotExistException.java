package top.lemna.account.exception;

import java.text.MessageFormat;

public class RechargNotExistException extends RuntimeException {
  private static final long serialVersionUID = 5770390658812498742L;

  public RechargNotExistException(Long id, Long accountId) {
    super(MessageFormat.format("数据库中不存在ID为[{0}],accountId为[{1}]的充值记录", id, accountId));
  }

}
