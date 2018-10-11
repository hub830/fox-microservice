package top.lemna.account.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import top.lemna.account.persistence.entity.Account;
import top.lemna.account.persistence.service.AccountService;
import top.lemna.account.web.command.AccountCommand;
import top.lemna.core.validation.group.Add;

/**
 * 账户控制类
 * 
 * @author mux
 *
 */
@Slf4j
@RestController
@RequestMapping("pay/account")
public class AccountController {

  @Autowired
  AccountService service;


  @GetMapping("{id}")
  public Account get(@PathVariable Long id) {
    log.debug("查询账户 id:{}", id);
    return service.findById(id);
  }

  @PostMapping
  public Account post(@RequestBody @Validated(value = {Add.class}) AccountCommand command) {
    log.debug("新建账户 command:{}", command);
    Account account = service.create(command.getAccountName());
    return account;
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable Long id) {
    log.debug("删除账户 id:{}", id);
    service.delete(id);
  }

  @PutMapping("{id}")
  public Account put(@PathVariable Long id,@RequestBody @Validated AccountCommand command) {
    log.debug("账户修改 command:{}", command);
    Account account = service.findById(id);
    if (command.getBlock() != null) {
      account.setBlock(command.getBlock());
    }
    return service.save(account);
  }

}
