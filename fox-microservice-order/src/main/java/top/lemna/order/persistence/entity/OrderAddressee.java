package top.lemna.order.persistence.entity;

import lombok.Data;

/**
 * 订单收件人信息
 * 
 * @author toyota
 *
 */
@Data
public class OrderAddressee {

	// 固定电话
	private String telephone;

	// 手机号
	private String mobilePhone;

	// 所在地区
	private String area;

	// 地址
	private String address;

	// 邮编
	private int zipcode;

	// 收件人
	private String linkman;

	// 邮箱
	private String email;

	public OrderAddressee(String telephone, String mobilePhone, String area, String address, String linkman) {
		super();
		this.telephone = telephone;
		this.mobilePhone = mobilePhone;
		this.area = area;
		this.address = address;
		this.linkman = linkman;
	}

}
