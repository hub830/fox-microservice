package top.lemna.user.exception;

import java.text.MessageFormat;

public class UserAlreadyExistException extends RuntimeException {
  private static final long serialVersionUID = 5770390658812498742L;


  public UserAlreadyExistException(Long accountId, String merchantOrderNo) {
      super(MessageFormat.format("accountId 为[{0}] merchantOrderNo 为[{1}] 的订单记录已经存在",
          accountId, merchantOrderNo));
    }
}
