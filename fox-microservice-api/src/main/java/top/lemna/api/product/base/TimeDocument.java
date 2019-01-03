package top.lemna.api.product.base;

import java.util.Date;
import lombok.Data;


@Data
public abstract class TimeDocument {
  /** 创建时间 */
  private Date createtime;
  /** 更新时间 */
  private Date updatetime;

  public TimeDocument() {
    super();
  }

}
