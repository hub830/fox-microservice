package top.lemna.user.persistence.entity;

import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.AbstractDocument;

/**
 * 订单
 * 
 * @author toyota
 *
 */
@Data
@Document
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractDocument {

  // 用户编号
  @Indexed(unique = true)
  private long userNo;
  // 用户名称
  @Indexed(unique = true)
  private String username;
  // 用户呢称
  private String nickname;
  // 密码
  private String password;
  // 是否锁定 锁定用户无法登录
  private boolean locked;
  // 角色
  @DBRef
  private List<Role> roles;

  /**
   * 
   * @param username
   * @param nickname
   * @param password
   */
  public User(long userNo, String username, String nickname, String password) {
    super();
    this.userNo = userNo;
    this.username = username;
    this.nickname = nickname;
    this.password = password;
    this.locked = false;
  }

}
