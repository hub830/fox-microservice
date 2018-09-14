package top.lemna.order.persistence.service.base;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.fsg.uid.UidGenerator;

import top.lemna.order.persistence.entity.base.AbstractDocument;

public abstract class AbstractBaseService<T extends AbstractDocument>
{
    @Autowired
    private MongoRepository<T, Long> repository;

	@Autowired
	UidGenerator uidGenerator;

    public void delete( Long id )
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

    public void exists( Long id )
    {
        repository.existsById(id);
    }

    public Iterable<T> findAll()
    {
        return repository.findAll();
    }

    public Optional<T> findById( Long id )
    {
        return repository.findById(id);
    }

    @Transactional
    public T save( T entity )
    {
      if (entity.getId() == null) {
        Long uid = uidGenerator.getUID();
        entity.setId(uid);
      }
      entity.setUpdatetime(new Date());
        return repository.save(entity);
    }

}
