package top.lemna.api.product.model;

import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.lemna.api.product.base.AbstractDocument;
import top.lemna.core.enums.product.ProductStatus;

/**
 * 产品表
 * 
 * @author toyota
 *
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class Product extends AbstractDocument {


  private String name;

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
  @Size(min = 4, max = 256)
  private String imagePath;
  /**
   * 单价
   */
  @NotNull
  @Digits(integer = 8, fraction = 2)
  @Min(0)
  @Max(9999999)
  private Double price;
  /**
   * 库存
   */
  @NotNull
  @Min(0)
  @Max(9999999)
  private Long stock;

  @NotNull
  private List<ProductProperty> properties;
  /**
   * 运营商
   */
  private ProductCarrier carrier;

  private ProductCategory category;
  /**
   * 产品状态
   */
  private ProductStatus status;

  public Product(String name, String productNo, List<ProductProperty> properties,
      ProductCarrier carrier, ProductCategory category) {
    super();
    this.name = name;
    this.productNo = productNo;
    this.properties = properties;
    this.carrier = carrier;
    this.category = category;
    this.status = ProductStatus.PUBLISH;
  }


}
