package top.lemna.user.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.IdEntity;

/**
 * 地址
 * 
 * @author toyota
 *
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Address extends IdEntity {

  private static final long serialVersionUID = 1L;
  
  /**
   * 用户Id
   */
  @Column(columnDefinition = "bigint(32) NOT NULL COMMENT '用户Id'")
  private Long userId;

  /**
   * 固定电话
   */
  @Column(columnDefinition = "varchar(18) NOT NULL COMMENT '固定电话'")
  private String telephone;

  /**
   * 手机号
   */
  @Column(columnDefinition = "varchar(18) NOT NULL COMMENT '手机号'")
  private String mobilePhone;

  /**
   * 省
   */
  @Column(columnDefinition = "varchar(32) NOT NULL COMMENT '省'")
  private String province;

  /**
   * 市、县
   */
  @Column(columnDefinition = "varchar(32) NOT NULL COMMENT '市、县'")
  private String city;

  /**
   * 区、镇
   */
  @Column(columnDefinition = "varchar(32) NOT NULL COMMENT '区、镇'")
  private String district;

  /**
   * 地址
   */
  @Column(columnDefinition = "varchar(128) COMMENT '权限名称'")
  private String address;

  /**
   * 邮编
   */
  @Column(columnDefinition = "varchar(6) NOT NULL COMMENT '邮编'")
  private int zipcode;

  /**
   * 收件人
   */
  @Column(columnDefinition = "varchar(32) NOT NULL COMMENT '收件人'")
  private String linkman;

  /**
   * 邮箱
   */
  @Column(columnDefinition = "varchar(64) COMMENT '邮箱'")
  private String email;
}
