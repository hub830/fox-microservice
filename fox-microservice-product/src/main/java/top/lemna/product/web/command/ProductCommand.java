
package top.lemna.product.web.command;

import java.math.BigInteger;
import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.lemna.core.constraint.commons.LongSn;
import top.lemna.core.validation.group.Add;
import top.lemna.product.persistence.entity.Brand;
import top.lemna.product.persistence.entity.Category;
import top.lemna.product.persistence.entity.ProductProperties;
import top.lemna.product.web.command.validation.group.Stock;

/**
 * 交易
 * 
 * @author hu
 *
 */
@Data
@ToString
@NoArgsConstructor
public class ProductCommand {

  @LongSn
  private BigInteger id;

  @NotBlank(groups = {Add.class})
  @Size(min = 8, max = 64)
  private String name;

  @NotBlank(groups = {Add.class, Stock.class})
  @Size(min = 8, max = 64)
  private String productNo;
  
  /**
   *  库存
   */
  @NotNull(groups = {Add.class, Stock.class})
  @Min(0)
  @Max(9999999)
  private Long stock;
  
  /**
   *  简介
   */
  @NotBlank(groups = {Add.class})
  @Size(min = 8, max = 64)
  private String brief;
  
  /**
   *  描述
   */
  @Size(min = 8, max = 256)
  private String describe;
  
  /**
   *  运营商ID、品牌
   */
  @NotNull(groups = {Add.class})
  private Brand brand;
  
  /**
   *  分类ID
   */
  @NotNull(groups = {Add.class})
  private Category category;

  @NotNull
  private Set<ProductProperties> properties;


}
