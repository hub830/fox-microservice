package top.lemna.user.persistence.repository;


import org.springframework.stereotype.Repository;
import top.lemna.user.persistence.entity.UserInfo;
import top.lemna.user.persistence.repository.base.BaseRepository;

@Repository
public interface UserInfoRepository extends BaseRepository<UserInfo, Long> {

}
