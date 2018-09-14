package top.lemna.order.exception;

import java.text.MessageFormat;

public class OrderNotExistException extends RuntimeException {
  private static final long serialVersionUID = 5770390658812498742L;

  public OrderNotExistException(Long id) {
    super(MessageFormat.format("数据库中不存在ID为[{0}]的订单记录", id));
  }

  public OrderNotExistException(Long accountId, String merchantOrderNo) {
    super(MessageFormat.format("数据库中不存在 accountId 为[{0}] merchantOrderNo 为[{1}] 的订单记录",
        accountId, merchantOrderNo));
  }
}
