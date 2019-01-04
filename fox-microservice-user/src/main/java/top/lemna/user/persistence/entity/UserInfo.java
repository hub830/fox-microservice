package top.lemna.user.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.lemna.user.persistence.entity.base.IdEntity;

/**
 * 用户信息
 * 
 * @author toyota
 *
 */
@Data
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)

public class UserInfo extends IdEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 账户编号
   */
  @Column(columnDefinition = "int(32) NOT NULL COMMENT '账户编号'")
  private Long accountId;


  @OneToOne(targetEntity = User.class)
  @JoinColumn(name = "user_id",referencedColumnName = "id")
  private User user;
  
}
