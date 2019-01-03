package top.lemna.product.persistence.repository;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import top.lemna.product.persistence.entity.ProductCarrier;
import top.lemna.product.persistence.repository.base.BaseRepository;


@Repository
public interface  ProductCarrierRepository extends BaseRepository<ProductCarrier, BigInteger> {
  Optional<ProductCarrier> findByName(String name);
}