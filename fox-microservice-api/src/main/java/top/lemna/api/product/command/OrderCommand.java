
package top.lemna.api.product.command;

import java.util.List;
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
public class OrderCommand {

  /**
   * 定单编号
   */
  @NotNull
  private Long orderNo;

  /**
   * 用户编号
   */
  @NotNull
  private Long userNo;

  /**
   * 用户名称
   */
  @NotNull
  private String userName;

  @NotNull
  @Size(min = 1, max = 99)
  private List<OrderItemCommand> items;

  public OrderCommand(Long orderNo, Long userNo, String userName, List<OrderItemCommand> items) {
    super();
    this.orderNo = orderNo;
    this.userNo = userNo;
    this.userName = userName;
    this.items = items;
  }
}
