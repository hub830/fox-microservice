package top.lemna.product.exception;

import top.lemna.core.utils.StringFormatUtil;

public class ProductCategoryNotExistException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;
  private String categoryName;

  public ProductCategoryNotExistException(String categoryName) {
    super(StringFormatUtil.format("数据库中不存在对应的产品分类 categoryName:{}",  categoryName));
    this.categoryName = categoryName;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
  
}
