package top.lemna.account.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.account.persistence.entity.base.IdEntity;
import top.lemna.core.enums.account.BillStatus;
import top.lemna.core.enums.account.BillType;

/**
 * 交易表
 * 
 * @author toyota
 *
 */
@Data
@Entity(name = "account_trade")
@EqualsAndHashCode(callSuper = false)
public class Trade extends IdEntity {

    private static final long serialVersionUID = 299101453982987455L;

    /** 账户ID */
    @Column(length = 32, nullable = false)
    private Long accountId;
    
    /** 交易名称，通常为交易内容 */
    @Column(length = 64, nullable = false)
    private String tradeName;

    /** 收入发生额  单位为分 */
    @Column(length = 16, nullable = false)
    private Long income;

    /** 支出发生额    单位为分 */
    @Column(length = 16, nullable = false)
    private Long outlay;
    
    /** 交易类型 */
    @Column(length = 32, nullable = false)
    @Enumerated(EnumType.STRING)
    private BillType type;

    /** 交易状态 */
    @Column(length = 32, nullable = false)
    @Enumerated(EnumType.STRING)
    private BillStatus status;

    /** 备注 */
    @Column(length = 256)
    private String remark;


    public Trade(Long accountId, String tradeName, Long income, Long outlay,
        BillType type) {
      super();
      this.accountId = accountId;
      this.tradeName = tradeName;
      this.income = income;
      this.outlay = outlay;
      this.type = type;
      this.status = BillStatus.PAYMENT;
    }
}
