
package top.lemna.product.web.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

/**
 * 购物车对象
 * 
 * @author hu
 *
 */
@Data
@ToString
public class ShoppingCartItemCommand {

  @NotBlank
  @Size(min = 8, max = 64)
  private String productNo;

  // 采购数量
  @NotNull
  @Min(0)
  @Max(9999999)
  private Integer number;

  public ShoppingCartItemCommand() {
    super();
  }

  public ShoppingCartItemCommand(String productNo, Integer number) {
    super();
    this.productNo = productNo;
    this.number = number;
  }

}
