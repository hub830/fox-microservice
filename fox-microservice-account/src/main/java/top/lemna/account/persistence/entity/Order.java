package top.lemna.account.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.account.persistence.entity.base.IdEntity;

/**
 * 账户表
 * 
 * @author toyota
 *
 */
@Data
@Entity(name = "account_orders")
@EqualsAndHashCode(callSuper = false)
public class Order extends IdEntity {

  private static final long serialVersionUID = 299101453982987455L;

  /** 借记账户ID 通常为商户账户ID 收款方 */
  @Column(length = 32, nullable = false)
  private Long accountId;

  /** 商户订单号 */
  @Column(length = 32, nullable = false)
  private String merchantOrderNo;

  /** 发生额 单位为分 */
  @Column(length = 16, nullable = false)
  private Long amount;

  /** 备注 */
  @Column(length = 256)
  private String remark;
  
  @OneToOne(cascade= {CascadeType.ALL})
  @JoinColumn(name="trade_id")
  private Trade trade;

  public Order(Long accountId, String merchantOrderNo, Long amount, String remark, Trade trade) {
    super();
    this.accountId = accountId;
    this.merchantOrderNo = merchantOrderNo;
    this.amount = amount;
    this.remark = remark;
    this.trade = trade;
  }
}
