package top.lemna.account.exception;

import java.text.MessageFormat;

import top.lemna.core.enums.account.BillStatus;
import top.lemna.core.enums.account.BillType;

public class TradeNotExistException extends RuntimeException {
  private static final long serialVersionUID = 5770390658812498742L;

  public TradeNotExistException(Long id, BillType type, BillStatus status) {
    super(MessageFormat.format("数据库中不存在 id 为[{0}] type 为[{1}] status 为[{2}] 的订单记录", id, type,
        status));
  }
}
