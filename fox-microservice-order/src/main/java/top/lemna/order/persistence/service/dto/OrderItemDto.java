package top.lemna.order.persistence.service.dto;

import lombok.Data;

/**
 * 订单列表，用于记录单个商品的购买数量、购买价格等信息
 * 
 * @author toyota
 *
 */
@Data
public class OrderItemDto {

  /**
   * 商品编号
   */
  private String productNo;

  /**
   * 商品规格
   */
  private String productSpec;

  /**
   * 数量
   */
  private int num;

  public OrderItemDto(String productNo, int num) {
    super();
    this.productNo = productNo;
    this.num = num;
  }
}
