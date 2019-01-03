package top.lemna.user.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import top.lemna.user.persistence.entity.Address;
import top.lemna.user.persistence.service.AddressBookService;

/**
 * 账户控制类
 * 
 * @author mux
 *
 */
@Slf4j
@RestController
@RequestMapping("user")
public class AddressController {

  @Autowired
  private AddressBookService addressBookService;

  @GetMapping(path = "{userNo}/address/{addressNo}")
  public Address pay(@PathVariable Long userNo, @PathVariable Long addressNo) {
    log.debug("GET 地址 userNo:{}, addressNo:{}", userNo, addressNo);
    Address address = addressBookService.findByUserNoAndAddressNo(userNo, addressNo);
    return address;
  }

  /*
   * @PostMapping(path = "place") public void place(@Valid UserRegisterCommand command) {
   * log.debug("下单 command:{}", command); }
   * 
   * @PostMapping(path = "pay") public void pay(@Valid UserRegisterCommand command) {
   * log.debug("支付 command:{}", command); }
   * 
   * @PostMapping(path = "delivery") public void delivery(@Valid UserRegisterCommand command) {
   * log.debug("发货 command:{}", command); }
   * 
   * @PostMapping(path = "receipt") public void receipt(@Valid UserRegisterCommand command) {
   * log.debug("收货 command:{}", command); }
   */

}
