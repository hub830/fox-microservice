package top.lemna.user.persistence.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import lombok.Data;

/**
 * 用户信息
 * 
 * @author toyota
 *
 */
@Data
public class UserInfo {
  // 用户编号
  @Indexed(unique = true)
  private long accountId;
}
