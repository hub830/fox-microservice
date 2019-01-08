package top.lemna.user.feign.client.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.lemna.api.account.model.Account;

// @RequestMapping("pay/account")
@FeignClient(name = "hops-microservice-user")
public interface AddressClient {

  @RequestMapping(method = RequestMethod.GET, value = "/pay/account")
  public Account get();

  @RequestMapping(method = RequestMethod.POST, value = "/pay/account")
  public Account post(Account account);

}
