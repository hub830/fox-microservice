package top.lemna.order.persistence.entity;

import java.util.Date;
import java.util.List;
import lombok.Data;
import top.lemna.core.enums.order.PaymentStatus;
import top.lemna.core.enums.order.PaymentType;

/**
 * 订单支付信息
 * 
 * @author toyota
 *
 */
@Data
public class OrderPayment {

  /** 支付时间 */
  private Date payTime;

  /** 商品总额 单位：分 */
  private Integer amount;

  /** 应付 单位：分 */
  private Integer payable;

  /** 支付方式 */
  private PaymentType type;

  /** 支付状态 */
  private PaymentStatus status;

  /** 支付详情 */
  private List<OrderPaymentItem> items;

  public OrderPayment(Integer amount, Integer payable, PaymentType type) {
    super();
    this.amount = amount;
    this.payable = payable;
    this.type = type;
  }
}
