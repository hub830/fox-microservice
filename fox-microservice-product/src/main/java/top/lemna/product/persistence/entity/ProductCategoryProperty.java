package top.lemna.product.persistence.entity;

import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
import lombok.Data;
import lombok.ToString;

/**
 * 产品分类属性关联表
 * 属性隶属于分类，一个分类拥有多个属性，属性可以是地区、业务类型、面值、是否漫游
 * 每个属性又拥有多个选项，如地区下有湖南、湖北 ，是否漫游下有漫游、非漫游
 * @author toyota
 *
 */
@Data
@ToString
public class ProductCategoryProperty {

  @Indexed(unique = true)
  private String name;

  private List<ProductCategoryPropertyOption> options;

  public ProductCategoryProperty(String name, List<ProductCategoryPropertyOption> options) {
    super();
    this.name = name;
    this.options = options;
  }
  
}
