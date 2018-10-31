package top.lemna.api.account.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.api.account.model.base.IdEntity;
import top.lemna.core.enums.commons.YesNo;

/**
 * 账户表
 * 
 * @author toyota
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Account extends IdEntity
{

    /** 户名 */
    private String accountName;

    /** 余额  单位为分*/
    private Long availableBalance;

    /** 冻结余额  单位为分*/
    private Long freezeBalance;

    /** 锁定 */
    private YesNo block;

}
