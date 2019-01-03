package top.lemna.product.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lemna.product.persistence.service.ProductService;
import top.lemna.product.web.command.ShoppingCartCommand;
import top.lemna.product.web.vo.ShoppingCartVo;

/**
 * 产品库存
 * @author mux
 *
 */
@RestController
@RequestMapping("product")
public class ProductStockController {

  @Autowired
  private ProductService service;

  /**
   * 针对 产品的批量操作
   * 批量减库存并返回对应的产品价格
   * @param command
   * @return
   */
  @PostMapping(value = "products/stock")
  public ShoppingCartVo stock(
      @RequestBody @Validated  ShoppingCartCommand shoppingCart) {
    ShoppingCartVo cartVo = service.sale(shoppingCart);
    return cartVo;
  }
}
