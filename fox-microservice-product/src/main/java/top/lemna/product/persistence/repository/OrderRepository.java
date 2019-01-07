package top.lemna.product.persistence.repository;

import java.math.BigInteger;
import org.springframework.stereotype.Repository;
import top.lemna.product.persistence.entity.Order;
import top.lemna.product.persistence.repository.base.BaseRepository;


@Repository
public interface OrderRepository extends BaseRepository<Order, BigInteger> {
}
