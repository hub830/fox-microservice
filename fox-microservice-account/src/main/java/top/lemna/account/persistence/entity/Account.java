package top.lemna.account.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.account.persistence.entity.base.IdEntity;
import top.lemna.core.enums.commons.YesNo;

/**
 * 账户表
 * 
 * @author toyota
 *
 */
@Data
@Entity
@Table(name = "account_account")
@EqualsAndHashCode(callSuper = false)
public class Account extends IdEntity
{

    private static final long serialVersionUID = 299101453982987455L;

    /** 户名 */
    @Column(length = 64, nullable = false)
    private String accountName;

    /** 余额  单位为分*/
	@Column(length = 16, nullable = false)
    private Long availableBalance;

    /** 冻结余额  单位为分*/
	@Column(length = 16, nullable = false)
    private Long freezeBalance;

    /** 锁定 */
    @Column(length = 32, nullable = false)
    @Enumerated(EnumType.STRING)
    private YesNo block;

    
    public Account(String accountName)
    {
        super();
        this.accountName = accountName;
        this.availableBalance = 0l;
        this.freezeBalance = 0l;
        this.block = YesNo.NO;
    }

}
