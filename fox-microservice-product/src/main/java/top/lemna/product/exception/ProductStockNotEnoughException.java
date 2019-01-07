package top.lemna.product.exception;

import lombok.Getter;

/**
 * 产品订单创建异常
 * @author mux
 *
 */
public class ProductStockNotEnoughException extends ProductOrderCreateEnoughException {

  private static final long serialVersionUID = 1L;

  @Getter
  private String productNo;

  public ProductStockNotEnoughException(String productNo) {
    super(messageFormat("数据库中不存在对应的产品 productNo:{}", productNo));
    this.productNo = productNo;
  }
}
