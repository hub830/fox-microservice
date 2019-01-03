package top.lemna.user.persistence.service;

import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lemna.user.persistence.entity.Privilege;
import top.lemna.user.persistence.service.PrivilegeService;

@RunWith(SpringRunner.class)
@SpringBootTest
// @RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PrivilegeServiceTest {

  @Autowired
  private PrivilegeService privilegeService;


  private Privilege privilege;

  @Before
  public void setup() {
//    privilege = new Privilege("增加", "PRIVILEGE_ADMIN_READ", "description for privilege admin read");
    privilege = new Privilege("查看", "PRIVILEGE_USER_READ", "description for privilege user read");
  }

  // @Test
  public void testFindById() {
    fail("Not yet implemented");
  }

  @Test
  public void testInsert() {
    privilegeService.save(privilege);
  }

}
