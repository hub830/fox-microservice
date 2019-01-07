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
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import top.lemna.product.web.command.OrderCommand;
import top.lemna.product.web.command.OrderItemCommand;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;


  private HttpHeaders headers;

  private OrderCommand command;

  @Before
  public void setup() {

    headers = new HttpHeaders();
    headers.add("api-version", "1.0");
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

    Long orderNo = 100001L;
    Long userNo = 100001L;
    String userName = "test";
    List<OrderItemCommand> items = new ArrayList<OrderItemCommand>();
    items.add(new OrderItemCommand("POS|M60|WRITE", 1));
    Integer totalNum = 2;
    command = new OrderCommand(orderNo, userNo, userName, items, totalNum);
  }


  @Test
  public void testSale() {

    final String baseUrl = "http://localhost:" + port + "";

    HttpEntity<String> entity = new HttpEntity<String>(JSON.toJSONString(command), headers);

    ResponseEntity<String> responseEntity =
        restTemplate.postForEntity(baseUrl + "/order/sale", entity, String.class);
    // Order order = responseEntity.getBody();
    log.info("-----------------请求完成，返回 order:{}", responseEntity);

  }

}
