package top.lemna.user.persistence.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.IdEntity;

/**
 * 角色
 * 
 * @author mux
 *
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(indexes = {//
    @Index(name = "i_role_name", columnList = "name", unique = true)//
})
public class Role extends IdEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 角色名称
   */
  @Column(columnDefinition = "varchar(64) NOT NULL COMMENT '角色名称'")
  private String name;

  /**
   * 角色描述
   */
  @Column(columnDefinition = "varchar(256) COMMENT '角色描述'")
  private String description;

  /**
   * 角色拥有的权限集合
   */
  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Privilege> privileges;

  public Role(String name, String description) {
    this.name = name;
    this.description = description;
  }
}
