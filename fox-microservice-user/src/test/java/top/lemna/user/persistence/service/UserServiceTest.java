package top.lemna.user.persistence.service;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import top.lemna.user.TestUserApplication;
import top.lemna.user.persistence.entity.Role;
import top.lemna.user.persistence.entity.User;
import top.lemna.user.persistence.service.dto.UserSignupDto;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestUserApplication.class)
public class UserServiceTest {

  private UserSignupDto dto;


  @Autowired
  UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private RoleService roleService;

  @Before
  public void setup() {
    dto = new UserSignupDto("user", "普通用户", "123456");
  }

  @Test
  public void testSave() {
    String password = passwordEncoder.encode("123456");
    User user = new User("13800138000", password);
    userService.save(user);
    assertThat(user.getId(), notNullValue());
  }


  @Test
  public void testSignup() {
    User user = userService.signup(dto);

    assertThat(user.getId(), notNullValue());
  }


  @Test
  public void testFindByUsername() {
    Optional<User> optional = userService.findByUsername("13800138000");
    Optional<Role> role = roleService.findByName("普通用户");
    User user = optional.get();
    Set<Role> roles = new HashSet<>();
    roles.add(role.get());
    user.setRoles(roles);
    userService.save(user);
  }

}
