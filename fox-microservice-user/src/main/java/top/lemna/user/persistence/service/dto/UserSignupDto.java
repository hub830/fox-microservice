
package top.lemna.user.persistence.service.dto;

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
	private String username;
	// 用户呢称
	private String nickname;
	// 密码
	private String password;

}
