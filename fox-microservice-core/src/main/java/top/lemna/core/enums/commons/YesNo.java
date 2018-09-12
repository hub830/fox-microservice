package top.lemna.core.enums.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum YesNo {
	YES("是"), //
	NO("否")//
	;

	private String name;

	private YesNo(String name) {
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
	
	public static List<Map<String, String>> maps()
	{
		YesNo[] values = values();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (YesNo item : values) {
			list.add(item.toMap());
		}
		return list;
	}
}