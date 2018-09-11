
package top.lemna.account.web.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import top.lemna.core.constraint.commons.LongSn;

/**
 * 退款
 * 
 * @author hu
 *
 */
@Data
@NoArgsConstructor
public class RefundCommand {

  /** 账户ID 商户方 */
  @LongSn
  private Long merchantId;
  
  /** 商户订单号 */
  @NotNull
  @Size(min = 12, max = 64)
  private String orderNo;
  
  /** 备注 */
  @Size(max = 128)
  private String remark;

}
