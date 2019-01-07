package top.lemna.order.persistence.entity;

import lombok.Data;
import top.lemna.core.enums.order.PaymentChannel;

/**
 * 订单支付详情
 * 
 * @author toyota
 *
 */
@Data
public class OrderPaymentItem {
  // 支付渠道
  private PaymentChannel channel;
  // 支付金额
  private double amount;
  // 外部支付订单号
  private String payOrderId;
}
