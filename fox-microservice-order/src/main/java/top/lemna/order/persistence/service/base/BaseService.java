package top.lemna.order.persistence.service.base;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.baidu.fsg.uid.UidGenerator;
import top.lemna.order.persistence.entity.base.TimeDocument;

public abstract class BaseService<T extends TimeDocument> {
  @Autowired
  private MongoRepository<T, Long> repository;

  @Autowired
  UidGenerator uidGenerator;

  public T save(T entity) {
    return repository.save(entity);
  }

  public <S extends T> List<S> saveAll(Iterable<S> entities) {
    return repository.saveAll(entities);
  }


  public void delete(Long id) {
    repository.deleteById(id);
  }

  public void delete(T entity) {
    repository.delete(entity);
  }

  public void delete(Iterable<? extends T> entities) {
    repository.deleteAll(entities);
  }

  public void exists(Long id) {
    repository.existsById(id);
  }

  public Iterable<T> findAll() {
    return repository.findAll();
  }

  public Optional<T> findById(Long id) {
    return repository.findById(id);
  }

}
