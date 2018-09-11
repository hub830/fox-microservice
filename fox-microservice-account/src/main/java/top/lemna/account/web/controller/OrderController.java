package top.lemna.account.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import top.lemna.account.persistence.service.OrderService;
import top.lemna.account.web.command.BillCommand;
import top.lemna.account.web.command.RefundCommand;

/**
 * 账户控制类
 * 
 * @author mux
 *
 */
@Slf4j
@RestController
@RequestMapping("pay/order")
public class OrderController {

  @Autowired
  private OrderService orderService;
  
  @PostMapping(path = "place")
  public void place(@Valid BillCommand command) {
    log.debug("支付 command:{}", command);
    orderService.place(command.getAccountId(),command.getOrderNo(),command.getAmount(),command.getRemark());
  }

  @PostMapping(path = "refund")
  public void refund(@Valid RefundCommand command) {
    log.debug("退款 command:{}", command);
    orderService.cancel(command.getMerchantId(),command.getOrderNo());
  }


  @PostMapping(path = "successsuccess")
  public void success(Long merchantId, String orderNo) {
    log.debug("成功 merchantId:{}, orderNo:{}", merchantId, orderNo);
    orderService.success(merchantId, orderNo);
  }

}
