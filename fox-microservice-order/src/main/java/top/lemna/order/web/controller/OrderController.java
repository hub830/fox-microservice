package top.lemna.order.web.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import top.lemna.order.persistence.service.OrderService;
import top.lemna.order.persistence.service.dto.OrderPlaceDto;

/**
 * 账户控制类
 * 
 * @author mux
 *
 */
@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public void place(@RequestBody @Valid OrderPlaceDto command, Authentication user) {
    log.info("------- 下单 command:{} user:{}", command, user);
    // orderService.place(userNo, userName, dto);
  }

  @PostMapping(path = "pay")
  public void pay(@Valid OrderPlaceDto command) {
    log.debug("支付 command:{}", command);
  }

  @PostMapping(path = "delivery")
  public void delivery(@Valid OrderPlaceDto command) {
    log.debug("发货 command:{}", command);
  }

  @PostMapping(path = "receipt")
  public void receipt(@Valid OrderPlaceDto command) {
    log.debug("收货 command:{}", command);
  }

}
