
package top.lemna.user.web.command;

import lombok.Data;

/**
 * 交易
 * 
 * @author hu
 *
 */
@Data
public class UserSignupCommand {

	// 用户名称
	private String username;
	// 用户呢称
	private String nickname;
	// 密码
	private String password;

}
