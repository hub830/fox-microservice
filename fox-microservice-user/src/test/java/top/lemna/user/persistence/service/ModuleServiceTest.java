package top.lemna.user.persistence.service;

import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lemna.user.persistence.entity.Module;
import top.lemna.user.persistence.entity.Privilege;

@RunWith(SpringRunner.class)
@SpringBootTest
// @RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ModuleServiceTest {

  @Autowired
  private ModuleService moduleService;

  private Module module;

  private List<Privilege> privileges;

  @Before
  public void setup() {
    module = new Module("用户管理", "用户创建、授权");
    privileges = new ArrayList<>();
    Privilege admin =
        new Privilege("增加", "PRIVILEGE_ADMIN_READ", "description for privilege admin read");
    privileges.add(admin);
    Privilege user =
        new Privilege("查看", "PRIVILEGE_USER_READ", "description for privilege user read");
    privileges.add(user);
    module.setPrivileges(privileges);
  }

  // @Test
  public void testFindById() {
    fail("Not yet implemented");
  }

  @Test
  public void testInsert() {
    moduleService.save(module);
  }

}
