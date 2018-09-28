package top.lemna.user.persistence.repository;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lemna.user.persistence.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  private String username;
  @Before
  public void setup() {
    username = "test";
  }

  @Test
  public void testFindByUsername() {
    Optional<User> user = userRepository.findByUsername(username);
    assertThat(user.get(), notNullValue());
  }

}
