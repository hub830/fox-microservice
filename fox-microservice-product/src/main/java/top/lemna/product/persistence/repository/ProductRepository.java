package top.lemna.product.persistence.repository;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import top.lemna.product.persistence.entity.Product;
import top.lemna.product.persistence.repository.base.BaseRepository;


@Repository
public interface  ProductRepository extends BaseRepository<Product, BigInteger> {

  Optional<Product> findByProductNo(String productNo);

}