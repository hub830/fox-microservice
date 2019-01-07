package top.lemna.core.enums.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

public enum PaymentChannel {
  WECHATPAY("微信"), //
  ALIPAY("支付宝"), //
  RED_ENVELOPE("红包"), //
  COUPON("优惠券"), //
  BALANCE("余额")//
  ;//

  private String name;

  private PaymentChannel(String name) {
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
    PaymentChannel[] values = values();
    List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    for (PaymentChannel item : values) {
      list.add(item.toMap());
    }
    return list;
  }
}
