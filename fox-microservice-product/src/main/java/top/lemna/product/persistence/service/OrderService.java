package top.lemna.product.persistence.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lemna.product.exception.ProductOrderZeroNumException;
import top.lemna.product.persistence.entity.Order;
import top.lemna.product.persistence.entity.OrderItem;
import top.lemna.product.persistence.entity.Product;
import top.lemna.product.persistence.repository.OrderRepository;
import top.lemna.product.persistence.service.base.BaseService;
import top.lemna.product.web.command.OrderCommand;
import top.lemna.product.web.command.OrderItemCommand;

/**
 * 产品订单管理.
 * 
 * @author hu
 * 
 */
@Service
public class OrderService extends BaseService<Order> {

  @Autowired
  private OrderRepository repository;

  @Autowired
  private ProductService productService;


  /**
   * 销售，用于批量减库存
   * 
   * @param commands
   * @return 减库存后的产品列表，用于给调用者计算销售价格
   */
  @Transactional
  public Order sale(OrderCommand command) {
    List<OrderItemCommand> commandItems = command.getItems();

    List<OrderItem> items = saleItem(command.getOrderNo(), commandItems);
    Order order = new Order(//
        command.getOrderNo(), //
        command.getUserNo(), //
        command.getUserName(), //
        items//
    );
    return save(order);
  }

  /**
   * 挨个商品减库存
   * @param orderNo
   * @param commandItems
   * @return
   */
  private List<OrderItem> saleItem(Long orderNo, List<OrderItemCommand> commandItems) {
    List<OrderItem> items = new ArrayList<OrderItem>();
    if (commandItems == null || commandItems.size() == 0) {
      throw new ProductOrderZeroNumException(orderNo);
    }
    for (OrderItemCommand c : commandItems) {
      if (c == null || c.getNum() == 0) {
        throw new ProductOrderZeroNumException(orderNo);
      }
      Product product = productService.sale(c.getProductNo(), c.getNum());
      OrderItem item = new OrderItem(product, c.getNum());
      items.add(item);
    }
    return items;
  }
}
