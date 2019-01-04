package top.lemna.user.persistence.listener;

import java.util.Date;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import top.lemna.user.persistence.entity.base.TimeEntity;

public class TimeEntityListener {
  @PrePersist
  public void prePersist(TimeEntity entity) {
    entity.setCreatetime(new Date());
    entity.setUpdatetime(new Date());
  }

  @PreUpdate
  public void preUpdate(TimeEntity entity) {
    entity.setUpdatetime(new Date());
  }
}
