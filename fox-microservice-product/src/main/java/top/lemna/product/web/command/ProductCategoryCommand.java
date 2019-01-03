
package top.lemna.product.web.command;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.lemna.core.constraint.commons.LongSn;
import top.lemna.core.validation.group.Add;
import top.lemna.product.persistence.entity.ProductCategoryProperty;

/**
 * 交易
 * 
 * @author hu
 *
 */
@Data
@NoArgsConstructor
public class ProductCategoryCommand {

  /** 分类名称 */
  @NotBlank(groups = {Add.class})
  @Size(min = 8, max = 64)
  private String name;

  /** 描述 */
  @Size(min = 8, max = 256)
  private String describe;

  /** 父分类ID */
  @LongSn
  private Long parentId;

  private List<ProductCategoryProperty> properties;
}
