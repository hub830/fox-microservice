package top.lemna.account.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import top.lemna.account.persistence.entity.Recharg;
import top.lemna.account.persistence.service.RechargService;
import top.lemna.account.web.command.RechargCommand;
import top.lemna.core.validation.group.Add;
import top.lemna.core.validation.group.Update;

/**
 * 充值控制器
 * 调用此控制器方法时需要注意，需要判断调用者具有查询或调用权限 ，以免出现A取消了B的充值记录或A查看了B的充值记得等情况
 * @author mux
 *
 */
@Slf4j
@RestController
@RequestMapping("pay/recharg")
public class RechargController {

  @Autowired
  RechargService service;

/*  @GetMapping
  public Page<Recharg> get(@QuerydslPredicate(root = Recharg.class) Predicate predicate,
      Pageable pageable, @RequestParam MultiValueMap<String, String> parameters) {
    log.debug("查询充值 parameters:{}", parameters);
    Page<Recharg> page = service.findAll(predicate, pageable);
    return page;
  }*/

  @GetMapping("{id}")
  public Recharg get(@PathVariable Long id) {
    log.debug("查询充值 id:{}", id);
    return service.findById(id);
  }

  @PostMapping
  public Recharg post(@RequestBody @Validated(value = {Add.class}) RechargCommand command) {
    log.debug("新建充值 command:{}", command);
    Recharg recharg = service.place(command.getAccountId(), command.getAmount(), command.getType(),
        command.getRemark());
    return recharg;
  }

  @PutMapping("{id}/success")
  public void success(@PathVariable Long id,
      @RequestBody @Validated(value = {Update.class}) RechargCommand command) {
    log.debug("充值成功 id:{}, command:{}",id, command);
    service.success(id, command.getAccountId());
  }

  @PutMapping("{id}/cancel")
  public void cancel(@PathVariable Long id,
      @RequestBody @Validated(value = {Update.class}) RechargCommand command) {
    log.debug("取消充值 id:{}, command:{}",id, command);
    service.cancel(id, command.getAccountId());
  }
}
