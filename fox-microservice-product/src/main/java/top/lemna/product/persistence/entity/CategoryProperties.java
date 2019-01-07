package top.lemna.product.persistence.entity;

import java.util.Set;
import org.springframework.data.mongodb.core.index.Indexed;
import lombok.Data;
import lombok.ToString;

/**
 * 产品分类属性关联表 属性隶属于分类，一个分类拥有多个属性，
 * <P/>
 * 属性可以是地区、业务类型、面值、是否漫游 每个属性又拥有多个选项，
 * <P/>
 * 如地区下有湖南、湖北 ，是否漫游下有漫游、非漫游
 * 
 * @author toyota
 *
 */
@Data
@ToString
public class CategoryProperties {

  @Indexed(unique = true)
  private String name;

  /**
   * 产品属性选项 产品选项隶属于产品属性 如地区属性下在有湖南、 湖北等选项，
   * <P/>
   * 是否漫游属性下有漫游、非漫游等选项
   *
   */
  private Set<String> options;

  public CategoryProperties(String name, Set<String> options) {
    super();
    this.name = name;
    this.options = options;
  }

}
