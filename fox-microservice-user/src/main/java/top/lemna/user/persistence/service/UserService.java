package top.lemna.user.persistence.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.baidu.fsg.uid.UidGenerator;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService extends BaseService<User> {

  private final UserRepository repository;

  private final UidGenerator uidGenerator;

  private final PasswordEncoder passwordEncoder;


  public Optional<User> findByUsername(String username) {
    return repository.findByUsername(username);
  }


  public Optional<User> findByUserNo(String userNo) {
    return repository.findByUserNo(userNo);
  }

  public User signup(UserSignupDto dto) {
    long userNo = uidGenerator.getUID();
    String password = passwordEncoder.encode(dto.getPassword());
    User user = new User(userNo, dto.getUsername(), dto.getNickname(), password);
    return save(user);
  }

}
