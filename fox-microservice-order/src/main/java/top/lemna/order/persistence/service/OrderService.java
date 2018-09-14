package top.lemna.order.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lemna.order.persistence.entity.Order;
import top.lemna.order.persistence.repository.OrderRepository;
import top.lemna.order.persistence.service.base.BaseService;

/**
 * 订单管理.
 * 
 * @author hu
 * 
 */
@Service
public class OrderService extends BaseService<Order> {

	@Autowired
	private OrderRepository repository;

	public OrderService() {
		super();
	}


}
