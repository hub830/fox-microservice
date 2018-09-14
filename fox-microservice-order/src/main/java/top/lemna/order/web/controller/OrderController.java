package top.lemna.order.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import top.lemna.order.persistence.service.OrderService;
import top.lemna.order.web.command.OrderPlaceCommand;

/**
 * 账户控制类
 * 
 * @author mux
 *
 */
@Slf4j
@RestController
@RequestMapping("order/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(path = "place")
	public void place(@Valid OrderPlaceCommand command) {
		log.debug("下单 command:{}", command);
	}

	@PostMapping(path = "pay")
	public void pay(@Valid OrderPlaceCommand command) {
		log.debug("支付 command:{}", command);
	}

	@PostMapping(path = "delivery")
	public void delivery(@Valid OrderPlaceCommand command) {
		log.debug("发货 command:{}", command);
	}
	
	@PostMapping(path = "receipt")
	public void receipt(@Valid OrderPlaceCommand command) {
		log.debug("收货 command:{}", command);
	}

}
