package top.lemna.product.persistence.entity;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.core.enums.product.OrderStatus;
import top.lemna.product.persistence.entity.base.AbstractDocument;

/**
 * 订单 用于库存的扣减与恢复
 * 
 * @author toyota
 *
 */
@Document
@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends AbstractDocument {

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
  private Integer totalMount;

  /**
   * 购买商品总数量
   */
  private Integer totalNumber;

  /**
   * 状态
   */
  private OrderStatus status;

  /**
   * 订单详情
   */
  private List<OrderItem> items;

  public Order(Long orderNo, Long userNo, String userName, List<OrderItem> items) {
    super();
    this.orderNo = orderNo;
    this.userNo = userNo;
    this.userName = userName;
    this.totalMount = 0;
    this.totalNumber = 0;
    this.items = items;
    for (OrderItem item : items) {
      this.totalMount += item.getAmount();
      this.totalNumber += item.getNum();
    }
    this.status = OrderStatus.COMPLETE;
  }




}
