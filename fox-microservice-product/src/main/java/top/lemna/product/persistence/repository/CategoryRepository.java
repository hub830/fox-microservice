package top.lemna.product.persistence.repository;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import top.lemna.product.persistence.entity.Category;
import top.lemna.product.persistence.repository.base.BaseRepository;


@Repository
public interface  CategoryRepository extends BaseRepository<Category, BigInteger> {
  Optional<Category> findByName(String name);
}