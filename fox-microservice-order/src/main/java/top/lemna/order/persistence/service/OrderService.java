package top.lemna.order.persistence.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baidu.fsg.uid.UidGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.lemna.api.product.command.OrderCommand;
import top.lemna.api.product.command.OrderItemCommand;
import top.lemna.order.feign.client.product.OrderClient;
import top.lemna.order.persistence.entity.Order;
import top.lemna.order.persistence.entity.Order.Builder;
import top.lemna.order.persistence.entity.OrderAddressee;
import top.lemna.order.persistence.entity.OrderDelivery;
import top.lemna.order.persistence.entity.OrderItem;
import top.lemna.order.persistence.entity.OrderPayment;
import top.lemna.order.persistence.repository.OrderRepository;
import top.lemna.order.persistence.service.base.AbstractBaseService;
import top.lemna.order.persistence.service.dto.OrderItemDto;
import top.lemna.order.persistence.service.dto.OrderPlaceDto;

/**
 * 订单管理.
 * 
 * @author hu
 * 
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService extends AbstractBaseService<Order> {

  private final OrderRepository repository;

  private final OrderClient orderClient;

  private final UidGenerator uidGenerator;


  @Transactional
  private Order create(Long userNo, String userName, OrderPlaceDto dto) {
    log.debug("订单创建 userNo:{}, userName:{}, dto:{}", userNo, userName, dto);
    Long orderNo = uidGenerator.getUID();
    // 获取收货地址信息
    // TODO 获取收货地址信息
    OrderAddressee addressee = null;
    // 构造发货信息 单号及承运公司在发货后再填写
    OrderDelivery delivery = new OrderDelivery(dto.getDeliveryMethod());
    Builder builder = new Order.Builder(orderNo, userNo, userName, dto.getOrderType());
    Order order = builder//
        .addressee(null)//
        .delivery(delivery)//
        // .items(dto.getItems())//
        .build();
    order = save(order);
    return order;
  }


  /**
   * 订单下单
   * 
   * @param userNo
   * @param userName
   * @param dto
   * @return
   */
  @Transactional
  public Order place(Long userNo, String userName, OrderPlaceDto dto) {
    log.info("订单下单 userNo:{}, userName:{}, dto:{}", userNo, userName, dto);
    /*
     * 生成订单
     */
    Order order = create(userNo, userName, dto);
    /*
     * 减库存 获得订单金额
     */
    top.lemna.api.product.model.Order productOrder =
        reductionStock(userNo, userName, order.getOrderNo(), dto.getItems());

    /*
     * 更新订单详情
     */
    List<OrderItem> items = generateOrderItem(productOrder.getItems());
    order.setItems(items);
    /*
     * 更新支付金额
     */
    OrderPayment pay =
        new OrderPayment(productOrder.getAmount(), productOrder.getAmount(), dto.getPaymentType());
    order.setPayment(pay);
    return save(order);
  }

  /**
   * 调用产品模块扣减库存，并获取销售金额
   * 
   * @param userNo
   * @param userName
   * @param orderNo
   * @param items
   * @return
   */
  private top.lemna.api.product.model.Order reductionStock(Long userNo, String userName,
      Long orderNo, List<OrderItemDto> items) {

    List<OrderItemCommand> commandItems = new ArrayList<OrderItemCommand>();

    for (OrderItemDto item : items) {
      commandItems.add(new OrderItemCommand(item.getProductNo(), item.getNum()));
    }

    OrderCommand command = new OrderCommand(orderNo, userNo, userName, commandItems);
    return orderClient.sale(command);
  }

  private List<OrderItem> generateOrderItem(List<top.lemna.api.product.model.OrderItem> items) {
    List<OrderItem> list = new ArrayList<>();
    for (top.lemna.api.product.model.OrderItem pi : items) {
      OrderItem item = new OrderItem();
      item.setAmount(pi.getAmount());
      item.setNum(pi.getNum());
      item.setPrice(pi.getPrice());
      item.setProductName(pi.getProductName());
      item.setProductNo(pi.getProductNo());
      list.add(item);
    }
    return list;
  }
}
