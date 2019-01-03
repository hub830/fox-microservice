package top.lemna.product.web.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lemna.product.persistence.service.ProductCarrierService;

@RestController
@RequestMapping("product/carrier")
public class ProductCarrierController {

  @Autowired
  private ProductCarrierService service;



  /**
   * 下单接口
   * 
   * @param templateId
   * @param data
   * @return
   */
  @PostMapping(value = "place/{templateId}")
  public Map<String, String> place(@PathVariable("templateId") String templateId,
      @RequestBody Map<String, Object> data) {

    return null;
  }


}
