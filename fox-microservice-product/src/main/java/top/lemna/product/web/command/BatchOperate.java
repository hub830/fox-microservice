
package top.lemna.product.web.command;

import java.util.List;
import lombok.Data;
import top.lemna.core.constraint.commons.LongSn;

/**
 * 交易
 * 
 * @author hu
 *
 */
@Data
public class BatchOperate<T> {

  @LongSn
  private OperateMethod method;
  
  private List<T> items;
}
