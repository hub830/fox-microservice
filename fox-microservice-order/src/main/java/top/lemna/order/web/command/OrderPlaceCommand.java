
package top.lemna.order.web.command;

import java.util.List;

import lombok.Data;
import top.lemna.core.enums.order.DeliveryMethod;
import top.lemna.core.enums.order.OrderType;
import top.lemna.core.enums.order.PaymentType;
import top.lemna.order.persistence.entity.OrderAddressee;
import top.lemna.order.persistence.entity.OrderItem;

/**
 * 交易
 * 
 * @author hu
 *
 */
@Data
public class OrderPlaceCommand {

	// 订单类型
	private OrderType orderType;
	//支付方式
	private PaymentType paymentType;
	// 配送方式
	private DeliveryMethod deliveryMethod;
	/** 收件人信息 */
	private OrderAddressee addressee;
	/** 订单详情 */
	private List<OrderItem> items;

}
