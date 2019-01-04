package top.lemna.user.persistence.repository;


import java.util.Optional;
import org.springframework.stereotype.Repository;
import top.lemna.user.persistence.entity.Role;
import top.lemna.user.persistence.repository.base.BaseRepository;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {

  Optional<Role> findByName(String name);
}
