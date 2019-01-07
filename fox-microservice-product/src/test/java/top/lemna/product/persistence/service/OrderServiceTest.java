package top.lemna.product.persistence.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import top.lemna.product.persistence.entity.Order;
import top.lemna.product.web.command.OrderCommand;
import top.lemna.product.web.command.OrderItemCommand;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

  @Autowired
  private OrderService orderService;

  private OrderCommand command;

  @Before
  public void setup() {
    Long orderNo = 100001L;
    Long userNo = 100001L;
    String userName = "test";
    List<OrderItemCommand> items = new ArrayList<OrderItemCommand>();
    items.add(new OrderItemCommand("POS|M60|WRITE", 1));
    command = new OrderCommand(orderNo, userNo, userName, items);
  }

  @Test
  public void testSale() {
    Order order = orderService.sale(command);
    log.info("----------------------------------------------------------------------");
    log.info("-----order:{}", order);
    log.info("----------------------------------------------------------------------");
  }

}
