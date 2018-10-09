package top.lemna.user.persistence.service;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import top.lemna.user.persistence.entity.Role;
import top.lemna.user.persistence.entity.User;
import top.lemna.user.persistence.service.dto.UserSignupDto;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

  private UserSignupDto dto;
  

  @Autowired
  UserService userService;
  
  @Autowired
  private RoleService roleService;

  @Before
  public void setup() {
    dto = new UserSignupDto("user", "普通用户", "123456");
  }

  @Test
  public void testSignup() {
    User user = userService.signup(dto);

    assertThat(user.getUserNo(), notNullValue());
  }


  @Test
  public void testFindByUsername() {
    Optional<User> optional = userService.findByUsername("user");
    Optional<Role> role = roleService.findByName("ROLE_USER");
    User user = optional.get();
    List<Role> roles = new ArrayList<>();
    roles.add(role.get());
    user.setRoles(roles);
    userService.save(user);
  }

}
