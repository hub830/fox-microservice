package top.lemna.product.persistence.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 产品属性选项
 * 产品选项隶属于产品属性
 * 如地区属性下在有湖南、湖北等选项，是否漫游属性下有漫游、非漫游等选项
 * @author toyota
 *
 */
@Data
@ToString
public class ProductCategoryPropertyOption {
  public String name;

  public ProductCategoryPropertyOption(String name) {
    super();
    this.name = name;
  }
}
