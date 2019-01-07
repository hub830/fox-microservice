
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

  /**
   * 购买商品总数量
   */
  @NotNull
  @Min(1)
  @Max(20000)
  private Integer totalNum;

  @NotNull
  @Size(min = 1, max = 99)
  private List<OrderItemCommand> items;

  public OrderCommand(Long orderNo, Long userNo, String userName, List<OrderItemCommand> items,
      Integer totalNum) {
    super();
    this.orderNo = orderNo;
    this.userNo = userNo;
    this.userName = userName;
    this.items = items;
    this.totalNum = totalNum;
  }
}
