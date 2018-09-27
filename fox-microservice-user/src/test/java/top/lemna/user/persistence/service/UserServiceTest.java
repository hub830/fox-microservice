package top.lemna.user.persistence.service;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import top.lemna.user.persistence.entity.User;
import top.lemna.user.persistence.service.dto.UserSignupDto;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

  private UserSignupDto dto;
  
  private long userNo;

  @Autowired
  UserService userService;

  @Before
  public void setup() {
    dto = new UserSignupDto("test", "测试", "123456");
    userNo = 2552492260784603136l;
  }

  @Test
  public void testSignup() {
    User user = userService.signup(dto);

    assertThat(user.getUserNo(), notNullValue());
  }


  @Test
  public void testFindById() {
    Optional<User> user = userService.findById(userNo);
    log.info("-------------------------------------------------------------");
    log.info(JSON.toJSONString(user.get()));
    
    assertThat(user.get(), notNullValue());
  }
 

}
