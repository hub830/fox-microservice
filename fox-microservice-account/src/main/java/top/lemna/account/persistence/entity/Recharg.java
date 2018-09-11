package top.lemna.account.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.account.persistence.entity.base.IdEntity;
import top.lemna.core.enums.account.RechargerType;

/**
 * 充值记录表
 * 
 * @author toyota
 *
 */
@Data
@Entity(name = "account_recharg")
@EqualsAndHashCode(callSuper = false)
public class Recharg extends IdEntity
{

    private static final long serialVersionUID = 299101453982987455L;

    /** 账号 */
    @Column(length = 32, nullable = false)
    private Long accountId;

    /** 充值金额 */
    @Column(precision = 12, scale = 2, nullable = false)
    private Long amount;

    /** 充值类型 充值渠道 */
    @Column(length = 32, nullable = false)
    @Enumerated(EnumType.STRING)
    private RechargerType type;

    /** 备注 */
    @Column(length = 256)
    private String remark;

    @OneToOne(cascade= {CascadeType.ALL})
    @JoinColumn(name="trade_id")
    private Trade trade;

    public Recharg(Long accountId, Long amount, RechargerType type,String remark,Trade trade) {
        super();
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
        this.remark = remark;
        this.trade = trade;
    }

    
}
