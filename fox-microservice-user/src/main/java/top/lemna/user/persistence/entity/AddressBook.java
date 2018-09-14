package top.lemna.user.persistence.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * 订单
 * 
 * @author toyota
 *
 */
@Data
@Document
public class AddressBook {
	// 用户编号
	private Long userNo;
	
	//地址本条数
	private int count;
	
	//默认地址ID
	private Long defaultAddressId;
	
	//地址
	private List<Address> address;
}
