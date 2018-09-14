package top.lemna.core.enums.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
/**
 * 配送方式
 * @author mux
 *
 */
public enum DeliveryMethod {
	SELF_PICKUP("自提"), //
	NORMAL_EXPRESS("普通快递")
	;//

	private String name;

	private DeliveryMethod(String name) {
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
		DeliveryMethod[] values = values();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (DeliveryMethod item : values) {
			list.add(item.toMap());
		}
		return list;
	}
}