package top.lemna.core.enums.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum RechargerType {
	REMIT("汇款"), //
	CYBER_BANK("网银"), //
	OTHER("其它")//
	;//

	private String name;

	private RechargerType(String name) {
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
		RechargerType[] values = values();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (RechargerType item : values) {
			list.add(item.toMap());
		}
		return list;
	}
}