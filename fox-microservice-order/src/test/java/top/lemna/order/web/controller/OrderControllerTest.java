package top.lemna.order.web.controller;

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
import top.lemna.core.enums.order.DeliveryMethod;
import top.lemna.core.enums.order.PaymentType;
import top.lemna.order.persistence.service.dto.OrderItemDto;
import top.lemna.order.persistence.service.dto.OrderPlaceDto;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate template;

  private OrderPlaceDto command;

  /**
   * TOKEN可以通过USER模块的登录测试用例获得
   */
  private String token =
      "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODI4NDkyNDYsInVzZXJfbmFtZSI6IjEzODAwMTM4MDAwIiwiYXV0aG9yaXRpZXMiOlsiTU9EVUxFX1BSSVZJTEVHRV9SRUFEIl0sImp0aSI6Ijc1YjgyYWY1LTFhM2YtNGQ4ZC05NTdiLWQwMzMxYTIwYmVlZCIsImNsaWVudF9pZCI6ImZveCIsInNjb3BlIjpbImFsbCJdfQ.1wXHpRsgrgetJdJs21bg9GMhClDkgD5SV5tlQ8Gg604";

  private HttpHeaders headers;

  @Before
  public void setup() {

    headers = new HttpHeaders();
    headers.add("api-version", "1.0");
    headers.add("Authorization", "bearer " + token);// 登录
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

    PaymentType paymentType = PaymentType.CASH_ON_DELIVERY;//
    DeliveryMethod deliveryMethod = DeliveryMethod.NORMAL_EXPRESS; //
    Long addresseeId = 9L; //
    List<OrderItemDto> items = new ArrayList<>();//
    items.add(new OrderItemDto("POS|M60|WRITE", 1));

    command = new OrderPlaceDto(paymentType, deliveryMethod, addresseeId, items);

  }

  @Test
  public void testPlace() {
    HttpEntity<String> entity = new HttpEntity<String>(JSON.toJSONString(command), headers);

    ResponseEntity<String> responseEntity =
        template.postForEntity("/order", entity, String.class);
    // Order order = responseEntity.getBody();
    log.info("-----------------------------------------------------------------------");
    log.info("-----------------请求完成，返回 order:{}", responseEntity);
    log.info("-----------------------------------------------------------------------");

  }

}
