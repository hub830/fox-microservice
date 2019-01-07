package top.lemna.product.exception;

public class ProductCategoryNotExistException extends ProductRuntimeException {
  
  private static final long serialVersionUID = 1L;
  private String categoryName;

  public ProductCategoryNotExistException(String categoryName) {
    super(messageFormat("数据库中不存在对应的产品分类 categoryName:{}",  categoryName));
    this.categoryName = categoryName;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
  
}
