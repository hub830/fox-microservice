package top.lemna.product.exception;

import lombok.Getter;
import top.lemna.core.utils.StringFormatUtil;

/**
 * 产品库存不足异常
 * 
 * @author mux
 *
 */
public class ProductStockNotEnoughException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  @Getter
  private String productNo;

  public ProductStockNotEnoughException(String productNo) {
    super(StringFormatUtil.format("数据库中不存在对应的产品 productNo:{}", productNo));
    this.productNo = productNo;
  }
}
