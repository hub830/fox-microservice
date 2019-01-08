package top.lemna.order.feign.client.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.lemna.api.product.BatchOperate;
import top.lemna.api.product.model.Product;

@FeignClient(name = "hops-microservice-product")
public interface ProductClient {

  @RequestMapping(method = RequestMethod.POST, value = "/product/products/stock")
  public Product sale(BatchOperate<Product> operate);

}
