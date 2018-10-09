package top.lemna.user.persistence.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lemna.user.persistence.entity.Privilege;
import top.lemna.user.persistence.entity.Role;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

  @Autowired
  private RoleService roleService;
  
  @Autowired
  private PrivilegeService privilegeService;

  private Role role;

  @Before
  public void setup() {
    role = new Role("ROLE_USER", "description for role user");

    List<Privilege> privileges = new ArrayList<Privilege>();
    Privilege privilege = privilegeService.findByOperation("PRIVILEGE_USER_READ");
    privileges.add(privilege);
    role.setPrivileges(privileges);
  }

  @Test
  public void testSave() {
    roleService.save(role);

    assertThat(role.getId(), notNullValue());
  }

}
