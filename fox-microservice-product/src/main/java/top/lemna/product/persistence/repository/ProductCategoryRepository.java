package top.lemna.product.persistence.repository;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import top.lemna.product.persistence.entity.ProductCategory;
import top.lemna.product.persistence.repository.base.BaseRepository;


@Repository
public interface  ProductCategoryRepository extends BaseRepository<ProductCategory, BigInteger> {
  Optional<ProductCategory> findByName(String name);
}