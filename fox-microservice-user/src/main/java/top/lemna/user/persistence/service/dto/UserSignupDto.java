
package top.lemna.user.persistence.service.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 用户注册
 * 
 * @author hu
 *
 */
@Data
public class UserSignupDto {

  // 用户名称
  @NotNull
  private String username;
  // 用户呢称
  @NotNull
  private String nickname;
  // 密码
  @NotNull
  private String password;

  public UserSignupDto(String username, String nickname, String password) {
    super();
    this.username = username;
    this.nickname = nickname;
    this.password = password;
  }

}
