
package top.lemna.product.web.vo;

import lombok.Data;
import lombok.ToString;

/**
 * 交易
 * 
 * @author hu
 *
 */
@Data
@ToString
public class ShoppingCartItemVo {
  // 产品编号
  private String productNo;

  // 购买数量
  private Integer number;

  // 单价
  private Integer price;

  // 单个产品合计金额
  private Integer totalMount;

  public ShoppingCartItemVo(String productNo, Integer number, Integer price) {
    super();
    this.productNo = productNo;
    this.number = number;
    this.price = price;
    this.totalMount = number * price;
  }
}
