package top.lemna.api.user.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单
 * 
 * @author toyota
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Address {

  // 地址编号
  private Long addressNo;
  // 固定电话
  private String telephone;

  // 手机号
  private String mobilePhone;

  // 省
  private String province;

  // 市、县
  private String city;

  // 区、镇
  private String district;

  // 所在地区
  private String area;

  // 地址
  private String address;

  // 邮编
  private int zipcode;

  // 收件人
  private String linkman;

  // 邮箱
  private String email;
}
