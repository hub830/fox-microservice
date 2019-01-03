package top.lemna.product.persistence.repository.base;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface  BaseRepository<T, ID> extends MongoRepository<T, ID>, QuerydslPredicateExecutor<T>
{

}