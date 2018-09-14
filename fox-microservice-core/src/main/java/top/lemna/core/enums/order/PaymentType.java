package top.lemna.core.enums.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum PaymentType {
	CASH_ON_DELIVERY("货到付款"), //
	ONLINE_PAYMENT("在线支付"), //
	OTHER("其它")//
	;//

	private String name;

	private PaymentType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> toMap() {
		return ImmutableMap.<String, String>builder()//
				.put("name", name)//
				.put("value", toString())//
				.build();
	}

	public static List<Map<String, String>> maps() {
		PaymentType[] values = values();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (PaymentType item : values) {
			list.add(item.toMap());
		}
		return list;
	}
}