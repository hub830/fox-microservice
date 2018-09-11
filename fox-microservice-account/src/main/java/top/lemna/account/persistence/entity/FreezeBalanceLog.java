package top.lemna.account.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.account.persistence.entity.base.IdEntity;

/**
 * 冻结流水表
 * 
 * @author toyota
 *
 */
@Data
@Entity(name = "account_freeze_balance_log")
@EqualsAndHashCode(callSuper = false)
public class FreezeBalanceLog extends IdEntity {

    private static final long serialVersionUID = 929088731917456529L;

    /** 账户ID */
    @Column(length = 32, nullable = false)
    private Long accountId;

    /** 支付定单号，非商户定单号 */
    @Column(length = 32, nullable = false)
    private Long orderId;

    /** 账户变动前总金额 付款方 单位为分 */
    @Column(length = 16, nullable = false)
    private Long beforeBalance;

    /** 账户变动后总金额 付款方 单位为分 */
    @Column(length = 16, nullable = false)
    private Long afterBalance;

    /** 备注 */
    @Column(length = 256)
    private String remark;

    public FreezeBalanceLog(Long accountId, Long orderId, Long beforeBalance, Long afterBalance,String remark) {
      super();
      this.accountId = accountId;
      this.orderId = orderId;
      this.beforeBalance = beforeBalance;
      this.afterBalance = afterBalance;
      this.remark = remark;
  }

}
