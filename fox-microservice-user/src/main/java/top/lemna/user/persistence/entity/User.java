package top.lemna.user.persistence.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.lemna.user.persistence.entity.base.IdEntity;

/**
 * 用户
 * 
 * @author toyota
 *
 */
@Data
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(indexes = {//
    @Index(name = "i_user_username", columnList = "username", unique = true)//
})
public class User extends IdEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 用户名称
   */
  @Column(columnDefinition = "varchar(64) NOT NULL COMMENT '用户名称'")
  private String username;

  /**
   * 密码
   */
  @Column(columnDefinition = "varchar(64) NOT NULL COMMENT '密码'")
  private String password;

  /**
   * 是否锁定 锁定用户无法登录
   */
  @Column(columnDefinition = "int(1) NOT NULL COMMENT '是否锁定'")
  private boolean locked;

  /**
   * 最后更改密码的时间
   */
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdatePasswordTime;

  /**
   * 角色
   */
  @ManyToMany(fetch = FetchType.LAZY)
  private Set<Role> roles;

  @OneToOne(mappedBy = "user")
  private UserInfo userInfo;

  /**
   * 
   * @param userNo
   * @param username
   * @param password
   */
  public User(String username, String password) {
    super();
    this.username = username;
    this.password = password;
    this.lastUpdatePasswordTime = new Date();
    this.locked = false;
  }

}
