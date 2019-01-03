package top.lemna.order.persistence.service;

import java.util.List;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baidu.fsg.uid.UidGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.lemna.order.persistence.entity.Order;
import top.lemna.order.persistence.entity.OrderAddressee;
import top.lemna.order.persistence.entity.OrderDelivery;
import top.lemna.order.persistence.entity.Order.Builder;
import top.lemna.order.persistence.entity.OrderItem;
import top.lemna.order.persistence.entity.OrderPayment;
import top.lemna.order.persistence.repository.OrderRepository;
import top.lemna.order.persistence.service.base.BaseService;
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
public class OrderService extends BaseService<Order> {

  private final OrderRepository repository;

  private final UidGenerator uidGenerator;


  @Transactional
  public Order create(Long userNo, String userName, OrderPlaceDto dto) {
    log.debug("订单创建 userNo:{}, userName:{}, dto:{}", userNo, userName, dto);
    Long orderNo = uidGenerator.getUID();
    // 获取收货地址信息
    //TODO  获取收货地址信息
    OrderAddressee addressee = null;
    // 构造发货信息 单号及承运公司在发货后再填写
    OrderDelivery delivery = new OrderDelivery(dto.getDeliveryMethod());
    Builder builder = new Order.Builder(orderNo, userNo, userName, dto.getOrderType());
    Order order = builder//
        .addressee(null)//
        .delivery(delivery)//
        .items(dto.getItems())//
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
    Order order = create( userNo, userName, dto);
    /*
     * 减库存 获得订单金额
     */
    List<OrderItem> items;
    /*
     * 更新订单金额
     */

    /*
     * 更新支付金额
     */
    OrderPayment pay = new OrderPayment(totalAmount, payable, type);
    return null;
  }

}
