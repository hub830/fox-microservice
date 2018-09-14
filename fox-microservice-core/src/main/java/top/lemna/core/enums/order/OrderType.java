package top.lemna.core.enums.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum OrderType {
	NORMAL("普通订单"), //
	OTHER("其它订单");//

	private String name;

	private OrderType(String name) {
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
		OrderType[] values = values();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (OrderType item : values) {
			list.add(item.toMap());
		}
		return list;
	}
}