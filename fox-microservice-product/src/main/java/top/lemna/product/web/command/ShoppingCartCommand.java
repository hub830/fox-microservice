
package top.lemna.product.web.command;

import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class ShoppingCartCommand {

  @NotNull
  @Size(min = 1, max = 99)
  private List<ShoppingCartItemCommand> items;

  // 购买商品总数量
  @NotNull
  @Min(1)
  @Max(20000)
  private Integer totalNumber;

  public ShoppingCartCommand(List<ShoppingCartItemCommand> items, Integer totalNumber) {
    super();
    this.items = items;
    this.totalNumber = totalNumber;
  }
}
