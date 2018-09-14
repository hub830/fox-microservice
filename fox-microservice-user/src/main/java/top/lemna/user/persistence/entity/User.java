package top.lemna.user.persistence.entity;

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
@Document
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends TimeDocument {
	// 用户编号
	private String userNo;
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
	 * @param userNo
	 * @param username
	 * @param nickname
	 * @param password
	 */
	public User(String userNo, String username, String nickname, String password) {
		super();
		this.userNo = userNo;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.locked = false;
	}

}
