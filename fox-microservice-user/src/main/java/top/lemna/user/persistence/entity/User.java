package top.lemna.user.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.TimeDocument;

/**
 * 订单
 * 
 * @author toyota
 *
 */
@Data
@Document
@EqualsAndHashCode(callSuper = false)
public class User extends TimeDocument {
  // 用户编号
  @Id
  private long userNo;
  // 用户名称
  private String username;
  // 用户呢称
  private String nickname;
  // 密码
  private String password;
  // 是否锁定 锁定用户无法登录
  private boolean locked;

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
