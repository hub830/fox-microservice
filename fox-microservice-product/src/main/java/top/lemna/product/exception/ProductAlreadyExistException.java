package top.lemna.product.exception;

import lombok.Getter;
import top.lemna.core.utils.StringFormatUtil;

public class ProductAlreadyExistException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  
  @Getter
  private String productNo;

  public ProductAlreadyExistException(String productNo) {
    super(StringFormatUtil.format("数据库中已经存在对应的产品 productNo:{}", productNo));
    this.productNo = productNo;
  }

}
