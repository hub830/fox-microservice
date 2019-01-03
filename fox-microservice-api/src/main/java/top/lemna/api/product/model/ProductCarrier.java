package top.lemna.api.product.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.lemna.api.product.base.AbstractDocument;

/**
 * 产品运营商表
 * 
 * @author toyota
 *
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class ProductCarrier extends AbstractDocument {

  private String name;
  
  private String describe;

  public ProductCarrier(String name, String describe) {
    super();
    this.name = name;
    this.describe = describe;
  }

}
