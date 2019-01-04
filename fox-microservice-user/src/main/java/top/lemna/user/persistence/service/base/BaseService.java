package top.lemna.user.persistence.service.base;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import com.baidu.fsg.uid.UidGenerator;
import top.lemna.core.persistence.exception.RecordNotExistException;
import top.lemna.user.persistence.entity.base.IdEntity;
import top.lemna.user.persistence.repository.base.BaseRepository;

public abstract class BaseService<T extends IdEntity> {

  @Autowired
  private BaseRepository<T, Long> repository;

  @Autowired
  UidGenerator uidGenerator;

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

  public T findById(Long id) {
    Optional<T> t = repository.findById(id);
    return t.orElseThrow(() -> new RecordNotExistException(id));
  }

  public Iterable<T> findAll() {
    return repository.findAll();
  }

  public Iterable<T> findAll(Specification<T> spec) {
    return repository.findAll(spec);
  }

  public Iterable<T> findAll(Specification<T> spec, Sort sort) {
    return repository.findAll(spec, sort);
  }

  public Page<T> findAll(Specification<T> spec, Pageable pageable) {
    return repository.findAll(spec, pageable);
  }

  public void count(Specification<T> spec) {
    repository.count(spec);
  }

  @Transactional
  public T save(T entity) {
    if (entity.getId() == null) {
      Long uid = uidGenerator.getUID();
      entity.setId(uid);
    }
    entity.setUpdatetime(new Date());
    return repository.save(entity);
  }

}
