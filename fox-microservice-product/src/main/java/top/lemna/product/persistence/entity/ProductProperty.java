package top.lemna.product.persistence.entity;

import lombok.Data;

/**
 * 产品与产品属性关联表
 * 
 * @author toyota
 *
 */
@Data
public class ProductProperty {

  public String propertyName;

  public String optionName;

  public ProductProperty(String propertyName, String optionName) {
    super();
    this.propertyName = propertyName;
    this.optionName = optionName;
  }
  

}
