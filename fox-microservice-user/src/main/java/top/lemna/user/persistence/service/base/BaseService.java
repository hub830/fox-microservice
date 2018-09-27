package top.lemna.user.persistence.service.base;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.baidu.fsg.uid.UidGenerator;

public abstract class BaseService<T extends Object>
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

    public T insert( T entity )
    {
      return repository.insert(entity);
    }

    public List<T> insert( Iterable<T> entities )
    {
      return repository.insert(entities);
    }
}
