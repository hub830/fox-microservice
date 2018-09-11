package top.lemna.account.persistence.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import top.lemna.account.persistence.entity.base.TimeEntity;

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
