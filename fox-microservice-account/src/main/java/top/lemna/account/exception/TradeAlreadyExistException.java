package top.lemna.account.exception;

import java.text.MessageFormat;

import top.lemna.core.enums.account.BillType;

public class TradeAlreadyExistException extends RuntimeException {
  private static final long serialVersionUID = 5770390658812498742L;


  public TradeAlreadyExistException(Long accountId, Long orderNo, BillType type) {
      super(MessageFormat.format("数据库中 accountId 为[{0}] orderNo 为[{1}]  type 为[{2}] 的订单记录已经存在", accountId,
          orderNo, type));
    }
}
