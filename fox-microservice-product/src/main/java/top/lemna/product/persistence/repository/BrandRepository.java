package top.lemna.product.persistence.repository;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import top.lemna.product.persistence.entity.Brand;
import top.lemna.product.persistence.repository.base.BaseRepository;


@Repository
public interface  BrandRepository extends BaseRepository<Brand, BigInteger> {
  Optional<Brand> findByName(String name);
}