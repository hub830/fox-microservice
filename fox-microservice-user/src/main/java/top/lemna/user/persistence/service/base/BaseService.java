package top.lemna.user.persistence.service.base;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.baidu.fsg.uid.UidGenerator;

public abstract class BaseService<T extends Object>
{
    @Autowired
    private MongoRepository<T, String> repository;

	@Autowired
	UidGenerator uidGenerator;

    public void delete( String id )
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

    public void exists( String id )
    {
        repository.existsById(id);
    }

    public Iterable<T> findAll()
    {
        return repository.findAll();
    }

    public Optional<T> findById( String id )
    {
        return repository.findById(id);
    }

    public T save( T entity )
    {
      return repository.save(entity);
    }
}
