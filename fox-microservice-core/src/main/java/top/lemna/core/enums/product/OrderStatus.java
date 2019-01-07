package top.lemna.core.enums.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum OrderStatus {
	COMPLETE("完成"), //
	CANCEL("取消")//
	;//

	private String name;

	private OrderStatus(String name) {
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
		OrderStatus[] values = values();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (OrderStatus item : values) {
			list.add(item.toMap());
		}
		return list;
	}
}