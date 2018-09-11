package top.lemna.core.enums.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum BillStatus {
	PAYMENT("待处理"), //
	SUCCESS("成功"), //
	REFUND("失败")//
	;//

	private String name;

	private BillStatus(String name) {
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
		BillStatus[] values = values();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (BillStatus item : values) {
			list.add(item.toMap());
		}
		return list;
	}
}