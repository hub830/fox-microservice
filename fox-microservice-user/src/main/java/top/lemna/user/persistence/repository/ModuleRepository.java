package top.lemna.user.persistence.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import top.lemna.user.persistence.entity.Module;

@Repository
public interface ModuleRepository extends MongoRepository<Module, String> {


}