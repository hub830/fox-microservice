package top.lemna.user.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import top.lemna.user.persistence.service.UserService;
import top.lemna.user.web.command.UserRegisterCommand;

/**
 * 账户控制类
 * 
 * @author mux
 *
 */
@Slf4j
@RestController
@RequestMapping("user/address")
public class AddressController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "place")
	public void place(@Valid UserRegisterCommand command) {
		log.debug("下单 command:{}", command);
	}

	@PostMapping(path = "pay")
	public void pay(@Valid UserRegisterCommand command) {
		log.debug("支付 command:{}", command);
	}

	@PostMapping(path = "delivery")
	public void delivery(@Valid UserRegisterCommand command) {
		log.debug("发货 command:{}", command);
	}
	
	@PostMapping(path = "receipt")
	public void receipt(@Valid UserRegisterCommand command) {
		log.debug("收货 command:{}", command);
	}

}
