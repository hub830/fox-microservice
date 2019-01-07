package top.lemna.product.persistence.entity;

import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.lemna.core.enums.product.ProductStatus;
import top.lemna.product.persistence.entity.base.AbstractDocument;

/**
 * 产品表
 * 
 * @author toyota
 *
 */
@Document
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
public class Product extends AbstractDocument {


  @NotNull
  @Indexed(unique = true)
  @Size(min = 4, max = 256)
  private String name;

  @NotNull
  @Indexed(unique = true)
  @Size(min = 4, max = 64)
  private String productNo;

  /**
   * 简介
   */
  @Size(min = 4, max = 64)
  private String brief;
  /**
   * 描述
   */
  @Size(min = 4, max = 256)
  private String describe;
  /**
   * 主图片路径，辅助图片根据主图片路径同目录获取
   */
  @NotNull
  @Size(min = 4, max = 256)
  private String imagePath;
  
  /**
   * 单价 单位：分
   */
  @NotNull
//  @Digits(integer = 8, fraction = 2)
  @Min(0)
  @Max(9999999)
  private Integer price;
  /**
   * 库存
   */
  @NotNull
  @Min(0)
  @Max(9999999)
  private Integer stock;

  @NotNull
  private Set<ProductProperties> properties;
  /**
   * 运营商、品牌
   */
  @NotNull
  @DBRef
  private Brand brand;

  @NotNull
  @DBRef
  private Category category;
  /**
   * 产品状态
   */
  @NotNull
  private ProductStatus status;

}
