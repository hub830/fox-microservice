package top.lemna.order.persistence.entity;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.core.enums.order.OrderStatus;
import top.lemna.core.enums.order.OrderType;
import top.lemna.order.persistence.entity.base.AbstractDocument;

/**
 * 订单
 * 
 * @author toyota
 *
 */
@Document
@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends AbstractDocument {
  // 总金额
  private double totalAmount;
  // 状态
  private OrderStatus status;
  // 定单编号
  private Long orderNo;
  // 用户编号
  private Long userNo;
  // 用户名称
  private String userName;
  // 订单类型
  private OrderType type;
  // 收件人信息
  private OrderAddressee addressee;
  // 配送信息
  private OrderDelivery delivery;
  // 付款信息
  private OrderPayment payment;
  // 订单详情
  private List<OrderItem> items;

  public Order(Builder builder) {
    super();
    this.status = OrderStatus.PLACE_ORDER;
    this.orderNo = builder.orderNo;
    this.userNo = builder.userNo;
    this.userName = builder.userName;
    this.type = builder.type;
    this.addressee = builder.addressee;
    this.delivery = builder.delivery;
    this.items = builder.items;
  }

  public static class Builder {
    // 定单编号
    private Long orderNo;
    // 用户编号
    private Long userNo;
    // 用户名称
    private String userName;
    // 订单类型
    private OrderType type;
    // 收件人信息
    private OrderAddressee addressee;
    // 配送信息
    private OrderDelivery delivery;
    // 订单详情
    private List<OrderItem> items;

    public Builder(Long orderNo, Long userNo, String userName, OrderType type) {
      this.orderNo = orderNo;
      this.userNo = userNo;
      this.userName = userName;
      this.type = type;
    }

    public Builder addressee(OrderAddressee addressee) {
      this.addressee = addressee;
      return this;
    }

    public Builder delivery(OrderDelivery delivery) {
      this.delivery = delivery;
      return this;
    }

    public Builder items(List<OrderItem> items) {
      this.items = items;
      return this;
    }

    public Order build() {
      return new Order(this);
    }
  }
}
