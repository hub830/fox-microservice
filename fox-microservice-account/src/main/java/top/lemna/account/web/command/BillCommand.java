
package top.lemna.account.web.command;

import javax.validation.constraints.Size;

import lombok.Data;
import top.lemna.core.constraint.account.Amount;
import top.lemna.core.constraint.commons.LongSn;

/**
 * 交易
 * 
 * @author hu
 *
 */
@Data
public class BillCommand {

  /** 账户ID 购买方 */
  @LongSn
  private Long accountId;

  /** 订单金额 单位为分 */
  @Amount
  private Long amount;

  /** 商户订单号 */
  @LongSn
  private String orderNo;

  /** 备注 */
  @Size(max = 128)
  private String remark;

  public BillCommand(Long accountId, Long amount, String orderNo, @Size(max = 128) String remark) {
    super();
    this.accountId = accountId;
    this.amount = amount;
    this.orderNo = orderNo;
    this.remark = remark;
  }

}
