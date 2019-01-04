package top.lemna.user.persistence.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lemna.user.UserTestApplication;
import top.lemna.user.persistence.entity.Privilege;
import top.lemna.user.persistence.entity.Role;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=UserTestApplication.class)
public class RoleServiceTest {

  @Autowired
  private RoleService roleService;
  
  @Autowired
  private PrivilegeService privilegeService;

  private Role role;

  @Before
  public void setup() {
    role = new Role("普通用户", "普通用户角色");

    Set<Privilege> privileges = new HashSet<Privilege>();
    Privilege privilege = privilegeService.findByOperation("MODULE_PRIVILEGE_READ");
    privileges.add(privilege);
    role.setPrivileges(privileges);
  }

  @Test
  public void testSave() {
    roleService.save(role);

    assertThat(role.getId(), notNullValue());
  }

}
