package top.lemna.api.product.model;

import java.util.List;
import lombok.Data;
import top.lemna.core.enums.product.OrderStatus;

/**
 * 订单 用于库存的扣减与恢复
 * 
 * @author toyota
 *
 */
@Data
public class Order {

  /**
   * 定单编号
   */
  private Long orderNo;

  /**
   * 用户编号
   */
  private Long userNo;

  /**
   * 用户名称
   */
  private String userName;

  /**
   * 所有产品金额合计
   */
  private Integer amount;

  /**
   * 购买商品总数量
   */
  private Integer num;

  /**
   * 状态
   */
  private OrderStatus status;

  /**
   * 订单详情
   */
  private List<OrderItem> items;

}
