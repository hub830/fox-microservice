package top.lemna.product.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import top.lemna.product.persistence.entity.Order;
import top.lemna.product.persistence.service.OrderService;
import top.lemna.product.web.command.OrderCommand;

/**
 * 产品库存
 * 
 * @author mux
 *
 */
@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

  @Autowired
  private OrderService service;

  /**
   * 针对 产品的批量操作 批量减库存并返回对应的产品价格
   * 
   * @param command
   * @return
   */
  @PostMapping(value = "sale", consumes = "application/json", produces = "application/json")
  public Order sale(@RequestBody @Validated OrderCommand orderCommand) {
    log.info("产品销售 orderCommand:{}", orderCommand);
    Order cartVo = service.sale(orderCommand);
    return cartVo;
  }
}
