package top.lemna.user.persistence.service;

import static org.junit.Assert.fail;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lemna.user.persistence.entity.Privilege;
import top.lemna.user.persistence.entity.PrivilegeModule;

@RunWith(SpringRunner.class)
@SpringBootTest
// @RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ModuleServiceTest {

  @Autowired
  private ModuleService moduleService;

  private PrivilegeModule module;

  private Set<Privilege> privileges;

  @Before
  public void setup() {
    module = new PrivilegeModule("用户管理", "用户创建、授权");
    privileges = new HashSet<>();
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
