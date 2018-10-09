package top.lemna.user.persistence.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import top.lemna.user.persistence.entity.Privilege;

@Repository
public interface PrivilegeRepository extends MongoRepository<Privilege, String> {

  Privilege findByOperation(String operation);
}
