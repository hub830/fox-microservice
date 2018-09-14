package top.lemna.user.persistence.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import top.lemna.user.persistence.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {


}