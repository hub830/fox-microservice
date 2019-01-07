package top.lemna.product.exception;

import lombok.Getter;

/**
 * 产品订单购买数量错误异常
 * 
 * @author mux
 *
 */
public class ProductOrderZeroNumException extends ProductOrderCreateEnoughException {

  private static final long serialVersionUID = 1L;

  @Getter
  private Long orderNo;

  public ProductOrderZeroNumException(Long orderNo) {
    super(messageFormat("订单:{} 购买的产品数量为量为零", orderNo));
    this.orderNo = orderNo;
  }
}
