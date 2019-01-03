package top.lemna.user.web.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import top.lemna.user.persistence.service.UserService;
import top.lemna.user.persistence.service.dto.UserSignupDto;

/**
 * 账户控制类
 * 
 * @author mux
 *
 */
@Slf4j
@RestController
@RequestMapping("user/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public void signup(@Valid @RequestBody UserSignupDto dto) {
    log.debug("注册 command:{}", dto);
    userService.signup(dto);
  }
  /*
   * @PutMapping(path = "password") public void updatePassword (@Valid UserRegisterCommand command)
   * { log.debug("修改密码 command:{}", command); }
   */
}
