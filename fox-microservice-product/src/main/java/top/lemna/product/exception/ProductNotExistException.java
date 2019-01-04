package top.lemna.product.exception;

import top.lemna.core.enums.product.ProductStatus;
import top.lemna.core.utils.StringFormatUtil;
import top.lemna.product.persistence.entity.Brand;
import top.lemna.product.persistence.entity.Category;

public class ProductNotExistException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ProductNotExistException(String areaNo, Brand carrier, Category category,
      ProductStatus status) {
    super(StringFormatUtil.format("数据库中不存在对应的产品 areaNo:{}, carrier:{}, category:{}, status:{}",
        areaNo, carrier, category, status));
  }


  public ProductNotExistException(String productNo) {
    super(StringFormatUtil.format("数据库中不存在对应的产品 productNo:{}", productNo));
  }
}
