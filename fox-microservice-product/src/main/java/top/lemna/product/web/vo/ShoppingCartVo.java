
package top.lemna.product.web.vo;

import java.util.List;
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
public class ShoppingCartVo {

  private List<ShoppingCartItemVo> items;

  // 所有产品金额合计
  private Integer totalMount;

  // 购买商品总数量
  private Integer totalNumber;

  public ShoppingCartVo(List<ShoppingCartItemVo> items, Integer totalMount, Integer totalNumber) {
    super();
    this.items = items;
    this.totalMount = totalMount;
    this.totalNumber = totalNumber;
  }
}
