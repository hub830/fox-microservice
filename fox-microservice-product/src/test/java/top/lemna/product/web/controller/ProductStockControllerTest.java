package top.lemna.product.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import top.lemna.product.web.command.ShoppingCartCommand;
import top.lemna.product.web.command.ShoppingCartItemCommand;
import top.lemna.product.web.vo.ShoppingCartVo;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductStockControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;
  
  private HttpHeaders requestHeaders;
  
  private ShoppingCartCommand command;
  
  @Before
  public void setup()
  {
    requestHeaders = new HttpHeaders();
    requestHeaders.add("api-version", "1.0");
    List<ShoppingCartItemCommand> items = new ArrayList<ShoppingCartItemCommand>();
    ShoppingCartItemCommand item1 = new ShoppingCartItemCommand("POS|M60|WRITE",  2);
    items.add(item1);
    command = new ShoppingCartCommand(items,2);
  }

  @Test
  public void testStock() {

    HttpEntity<ShoppingCartCommand> entity = new HttpEntity<ShoppingCartCommand>(command, requestHeaders);
        
    ResponseEntity<ShoppingCartVo> responseEntity = restTemplate.postForEntity("/product/products/stock", entity, ShoppingCartVo.class);
    ShoppingCartVo shoppingCartVo = responseEntity.getBody();
    log.info("----------------- shoppingCartVo:{}",shoppingCartVo);
  }

}
