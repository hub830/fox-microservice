package top.lemna.user.persistence.service.base;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.fsg.uid.UidGenerator;

import top.lemna.user.persistence.entity.base.AbstractDocument;

public abstract class AbstractBaseService<T extends AbstractDocument> extends BaseService<T>
{

	@Autowired
	UidGenerator uidGenerator;


    @Transactional
    public T save( T entity )
    {
      if (entity.getId() == null) {
        Long uid = uidGenerator.getUID();
        entity.setId(uid);
      }
      entity.setUpdatetime(new Date());
        return save(entity);
    }

}
