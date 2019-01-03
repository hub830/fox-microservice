package top.lemna.user.persistence.entity;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.lemna.user.persistence.entity.base.AbstractDocument;

/**
 * 用户
 * 
 * @author toyota
 *
 */
@Data
@ToString
@Document
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractDocument {
  // 用户编号
  @Indexed(unique = true)
  private Long userNo;
  // 用户名称
  @Indexed(unique = true)
  private String username;
  // 密码
  private String password;
  // 是否锁定 锁定用户无法登录
  private boolean locked;
  //最后更改密码的时间
  private Date lastUpdatePasswordTime;
  // 角色
  @DBRef
  private List<Role> roles;
  // 用户扩展信息
  private UserInfo userInfo;

  /**
   * 
   * @param userNo
   * @param username
   * @param nickname
   * @param password
   */
  public User(Long userNo, String username, String nickname, String password) {
    super();
    this.userNo = userNo;
    this.username = username;
    this.password = password;
    this.lastUpdatePasswordTime = new Date();
    this.locked = false;
  }

}
