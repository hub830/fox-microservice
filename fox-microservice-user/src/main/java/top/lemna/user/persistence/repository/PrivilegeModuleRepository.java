package top.lemna.user.persistence.repository;


import org.springframework.stereotype.Repository;
import top.lemna.user.persistence.entity.PrivilegeModule;
import top.lemna.user.persistence.repository.base.BaseRepository;

@Repository
public interface PrivilegeModuleRepository extends BaseRepository<PrivilegeModule, Long> {


}