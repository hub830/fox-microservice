package top.lemna.order.persistence.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import top.lemna.order.persistence.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {


}