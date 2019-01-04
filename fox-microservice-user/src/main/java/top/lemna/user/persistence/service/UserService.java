package top.lemna.user.persistence.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import top.lemna.api.account.model.Account;
import top.lemna.user.client.account.AccountClient;
import top.lemna.user.persistence.entity.User;
import top.lemna.user.persistence.entity.UserInfo;
import top.lemna.user.persistence.repository.UserRepository;
import top.lemna.user.persistence.service.base.BaseService;
import top.lemna.user.persistence.service.dto.UserSignupDto;

/**
 * 用户管理.
 * 
 * @author hu
 * 
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService extends BaseService<User> {

  private final UserRepository repository;

  private final PasswordEncoder passwordEncoder;

  private final AccountClient accountClient;

  public Optional<User> findByUsername(String username) {
    return repository.findByUsername(username);
  }

  @Transactional
  public User signup(UserSignupDto dto) {

    Account account = new Account();
    account.setAccountName(dto.getUsername());
    account = accountClient.post(account);
    UserInfo userInfo = new UserInfo();
    userInfo.setAccountId(account.getId());
    String password = passwordEncoder.encode(dto.getPassword());
    User user = new User(dto.getUsername(), password);
    // user.setUserInfo(userInfo);
    return save(user);
  }

}
