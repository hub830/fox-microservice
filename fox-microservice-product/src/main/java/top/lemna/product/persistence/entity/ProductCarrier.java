package top.lemna.product.persistence.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.lemna.product.persistence.entity.base.AbstractDocument;

/**
 * 产品运营商表
 * 
 * @author toyota
 *
 */
@Document
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class ProductCarrier extends AbstractDocument {

  @Indexed(unique = true)
  private String name;
  
  private String describe;

  public ProductCarrier(String name, String describe) {
    super();
    this.name = name;
    this.describe = describe;
  }

}
