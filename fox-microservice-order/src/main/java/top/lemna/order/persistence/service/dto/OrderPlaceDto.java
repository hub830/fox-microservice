
package top.lemna.order.persistence.service.dto;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import top.lemna.core.enums.order.DeliveryMethod;
import top.lemna.core.enums.order.OrderType;
import top.lemna.core.enums.order.PaymentType;
import top.lemna.order.persistence.entity.OrderItem;

/**
 * 交易
 * 
 * @author hu
 *
 */
@Data
public class OrderPlaceDto {

  // 订单类型
  @NotNull
  private OrderType orderType;
  // 支付方式
  @NotNull
  private PaymentType paymentType;
  // 配送方式
  @NotNull
  private DeliveryMethod deliveryMethod;
  /** 收件人信息 */
  private Long addresseeId;
  /** 订单详情 */
  @NotEmpty
  private List<OrderItem> items;

}
