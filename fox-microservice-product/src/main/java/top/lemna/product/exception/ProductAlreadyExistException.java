package top.lemna.product.exception;

import lombok.Getter;

public class ProductAlreadyExistException extends ProductRuntimeException {

  private static final long serialVersionUID = 1L;
  
  @Getter
  private String productNo;

  public ProductAlreadyExistException(String productNo) {
    super(messageFormat("数据库中已经存在对应的产品 productNo:{}", productNo));
    this.productNo = productNo;
  }

}
