package top.lemna.order.feign.client.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.lemna.api.product.command.OrderCommand;
import top.lemna.api.product.model.Order;

@FeignClient(name = "hops-microservice-product")
public interface OrderClient {

  @RequestMapping(method = RequestMethod.POST, value = "/order/sale")
  public Order sale(OrderCommand command);

}
