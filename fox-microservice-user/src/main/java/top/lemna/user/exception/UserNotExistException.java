package top.lemna.user.exception;

import java.text.MessageFormat;

public class UserNotExistException extends RuntimeException {
  private static final long serialVersionUID = 5770390658812498742L;

  public UserNotExistException(Long id) {
    super(MessageFormat.format("数据库中不存在ID为[{0}]的订单记录", id));
  }

  public UserNotExistException(Long accountId, String merchantOrderNo) {
    super(MessageFormat.format("数据库中不存在 accountId 为[{0}] merchantOrderNo 为[{1}] 的订单记录",
        accountId, merchantOrderNo));
  }
}
