package top.lemna.product.persistence.service.base;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import com.querydsl.core.types.Predicate;
import top.lemna.core.persistence.exception.RecordNotExistException;
import top.lemna.product.persistence.entity.base.AbstractDocument;
import top.lemna.product.persistence.repository.base.BaseRepository;

public abstract class BaseService<T extends AbstractDocument>
{
    @Autowired
    private BaseRepository<T, BigInteger> repository;


    public void delete( BigInteger id )
    {
        repository.deleteById(id);
    }

    public void delete( T entity )
    {
        repository.delete(entity);
    }

    public void delete( Iterable<? extends T> entities )
    {
        repository.deleteAll(entities);
    }

    public void exists( BigInteger id )
    {
        repository.existsById(id);
    }

    public Iterable<T> findAll()
    {
        return repository.findAll();
    }

    public T findById( BigInteger id )
    {
      Optional<T> t = repository.findById(id);
      return t.orElseThrow(() -> new RecordNotExistException(id));
    }


    public Iterable<T> findAll(Predicate predicate) {
      return repository.findAll(predicate);
    }


    public Iterable<T> findAll(Predicate predicate,  Sort sort) {
      return repository.findAll(predicate, sort);
    }


    public Page<T> findAll(Predicate predicate,  Pageable pageable) {
      return repository.findAll(predicate, pageable);
    }


    public void exists(Predicate predicate) {
      repository.exists(predicate);
    }


    public void count(Predicate predicate) {
      repository.count(predicate);
    }

    @Transactional
    public T save( T entity )
    {
      entity.setUpdatetime(new Date());
        return repository.save(entity);
    }

}
