package top.lemna.product.persistence.entity;

import lombok.Data;

/**
 * 订单列表，用于记录单个商品的购买数量、购买价格等信息
 * 
 * @author toyota
 *
 */
@Data
public class OrderItem {

  /**
   * 商品名称
   */
  private String productName;

  /**
   * 商品编号
   */
  private String productNo;

  /**
   * 单价 单位：分
   */
  private Integer price;

  /**
   * 数量
   */
  private Integer num;

  /**
   * 总价 单位：分
   */
  private Integer amount;

  public OrderItem(Product product,int num) {
    super();
    this.productName = product.getName();
    this.productNo = product.getProductNo();
    this.price = product.getPrice();
    this.num = num;
    this.amount = num*price;
  }

}
