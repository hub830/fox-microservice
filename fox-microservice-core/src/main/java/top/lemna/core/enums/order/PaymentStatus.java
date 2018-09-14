package top.lemna.core.enums.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum PaymentStatus {
	PAYMENT("待付款"), //
	SUCCESS("成功"), //
	REFUND("失败")//
	;//

	private String name;

	private PaymentStatus(String name) {
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
		PaymentStatus[] values = values();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (PaymentStatus item : values) {
			list.add(item.toMap());
		}
		return list;
	}
}