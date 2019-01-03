package top.lemna.order.persistence.entity;

import lombok.Data;

/**
 * 订单列表，用于记录单个商品的购买数量、购买价格等信息
 * 
 * @author toyota
 *
 */
@Data
public class OrderItem {

	//商品名称
	private String productName;
	//商品编号 
	private String productId;
	//商品规格 
	private String productSpec;
	//单价
	private double price;
	//数量
	private int quantity;
	//总价
	private double amount;

}
