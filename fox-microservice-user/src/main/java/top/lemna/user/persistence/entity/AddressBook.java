package top.lemna.user.persistence.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.IdEntity;

/**
 * 地址薄
 * 
 * @author toyota
 *
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class AddressBook extends IdEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 地址本条数
   */
  @Column(columnDefinition = "int(2) NOT NULL COMMENT '地址本条数'")
  private int count;

  /**
   * 默认地址编号
   */
  @Column(columnDefinition = "bigint(32)  COMMENT '默认地址编号'")
  private Long defaultAddressNo;

  @OneToOne(targetEntity = User.class)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @OneToMany(fetch = FetchType.LAZY) 
  private Set<Address> address = new HashSet<Address>();

}
