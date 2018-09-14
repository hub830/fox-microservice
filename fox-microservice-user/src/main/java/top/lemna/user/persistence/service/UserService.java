package top.lemna.user.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.fsg.uid.UidGenerator;

import top.lemna.user.persistence.entity.User;
import top.lemna.user.persistence.repository.UserRepository;
import top.lemna.user.persistence.service.base.BaseService;
import top.lemna.user.persistence.service.dto.UserSignupDto;

/**
 * 订单管理.
 * 
 * @author hu
 * 
 */
@Service
public class UserService extends BaseService<User> {

	@Autowired
	private UserRepository repository;

	@Autowired
	UidGenerator uidGenerator;
	

	public UserService() {
		super();
	}

	public User signup(UserSignupDto dto)
	{
		long userNo = uidGenerator.getUID();
		
	}

}
