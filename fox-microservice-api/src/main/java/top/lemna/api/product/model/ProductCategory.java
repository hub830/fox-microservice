package top.lemna.api.product.model;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.lemna.api.product.base.AbstractDocument;

/**
 * 产品分类表 Standard Product Unit （标准化产品单元） 一个产品属于一个分类，一个分类拥有多个属性，如地区，如业务类型，如面值
 * 
 * @author toyota
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class ProductCategory extends AbstractDocument {


  /**
   * 名称
   */
  private String name;

  /**
   * 描述
   */
  private String describe;

  /**
   * 父分类ID
   */
  private Long parentId;


  private List<ProductCategoryProperty> properties;


  public ProductCategory(String name, Long parentId, List<ProductCategoryProperty> properties) {
    super();
    this.name = name;
    this.parentId = parentId;
    this.properties = properties;
  }

}
