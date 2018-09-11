package top.lemna.account.persistence.repository.base;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


@NoRepositoryBean
public interface  BaseRepository<T, ID> extends PagingAndSortingRepository<T, ID>,JpaSpecificationExecutor<T>{

}