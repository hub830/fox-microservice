package top.lemna.product.persistence.entity.base;

import java.util.Date;
import org.springframework.data.annotation.Version;
import lombok.Data;


@Data
public abstract class TimeDocument {
  @Version
  private Integer optimistic;
  /** 创建时间 */
  private Date createtime = new Date();
  /** 更新时间 */
  private Date updatetime;

  public TimeDocument() {
    super();
  }

}
