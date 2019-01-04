package top.lemna.product.persistence.entity;

import lombok.Data;

/**
 * 产品与产品属性关联表
 * 
 * @author toyota
 *
 */
@Data
public class ProductProperties {

  public String propertyName;

  /**
   * 属性名，来源于CategoryProperties的 options
   */
  public String optionName;

  public ProductProperties(String propertyName, String optionName) {
    super();
    this.propertyName = propertyName;
    this.optionName = optionName;
  }

}
