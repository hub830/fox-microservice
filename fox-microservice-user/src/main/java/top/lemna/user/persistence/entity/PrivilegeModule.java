package top.lemna.user.persistence.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.IdEntity;

/**
 * 菜单模块，包含多个权限，主要用于授权界面的权限按组显示
 * 
 * @author mux
 *
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class PrivilegeModule extends IdEntity {
  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 级联保存、更新、删除、刷新;延迟加载
  private Set<Privilege> privileges;

  public PrivilegeModule(String name, String description) {
    super();
    this.name = name;
    this.description = description;
  }
}
