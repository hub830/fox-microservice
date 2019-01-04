package top.lemna.user.persistence.repository;


import java.util.Optional;
import org.springframework.stereotype.Repository;
import top.lemna.user.persistence.entity.User;
import top.lemna.user.persistence.repository.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

  Optional<User> findByUsername(String username);


}
