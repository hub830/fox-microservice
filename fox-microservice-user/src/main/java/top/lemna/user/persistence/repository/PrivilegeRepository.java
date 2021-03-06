package top.lemna.user.persistence.repository;


import org.springframework.stereotype.Repository;
import top.lemna.user.persistence.entity.Privilege;
import top.lemna.user.persistence.repository.base.BaseRepository;

@Repository
public interface PrivilegeRepository extends BaseRepository<Privilege, Long> {

  Privilege findByOperation(String operation);
}
