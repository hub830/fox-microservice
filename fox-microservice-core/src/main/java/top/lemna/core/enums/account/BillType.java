package top.lemna.core.enums.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum BillType {
	RECHARGE("充�??"), //
	WITHDRAW_CASH("提现"), //
	PAYMENT("交易"), //
	;//

	private String name;

	private BillType(String name) {
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
		BillType[] values = values();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (BillType item : values) {
			list.add(item.toMap());
		}
		return list;
	}
}