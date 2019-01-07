package top.lemna.product.persistence.entity;

import java.util.Set;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.lemna.product.persistence.entity.base.AbstractDocument;

/**
 * 产品分类表 Standard Product Unit （标准化产品单元） 一个产品属于一个分类，一个分类拥有多个属性，如地区，如业务类型，如面值
 * 
 * @author toyota
 *
 */
@Document
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class Category extends AbstractDocument {

  /**
   * 名称
   */
  @Indexed(unique = true)
  private String name;

  /**
   * 描述
   */
  private String describe;

  /**
   * 父分类ID
   */
  private Long parentId;


  private Set<CategoryProperties> properties;


  public Category(String name, Long parentId, Set<CategoryProperties> properties) {
    super();
    this.name = name;
    this.parentId = parentId;
    this.properties = properties;
  }

}
