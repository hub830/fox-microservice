package top.lemna.order.persistence.entity;

import java.util.Date;

import lombok.Data;
import top.lemna.core.enums.order.DeliveryMethod;

/**
 * 订单配送信息
 * 
 * @author toyota
 *
 */
@Data
public class OrderDelivery {

	// 配送方式
	private DeliveryMethod deliveryMethod;
	// 快递公司名称
	private String expressName;
	// 运费
	private double expressFee;
	// 单号
	private String trackingNumber;
	//发货日期
	private Date deliveryTime;
	
	public OrderDelivery(DeliveryMethod deliveryMethod) {
		super();
		this.deliveryMethod = deliveryMethod;
	}
	
}
