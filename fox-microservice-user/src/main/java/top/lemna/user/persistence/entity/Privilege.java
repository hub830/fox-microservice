package top.lemna.user.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.IdEntity;

/**
 * 权限
 * 
 * @author mux
 *
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(indexes = {//
    @Index(name = "i_privilege_name", columnList = "name", unique = true)//
})
public class Privilege extends IdEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 权限名称，用于显示
   */
  @Column(columnDefinition = "varchar(64) NOT NULL COMMENT '权限名称'")
  private String name;

  /**
   * 操作，用于做权限匹配
   */
  @Column(columnDefinition = "varchar(64) NOT NULL COMMENT '操作'")
  private String operation;

  /**
   * 权限描述
   */
  @Column(columnDefinition = "varchar(64) NOT NULL COMMENT '权限描述'")
  private String description;

  public Privilege(String name, String operation, String description) {
    super();
    this.name = name;
    this.operation = operation;
    this.description = description;
  }
}
