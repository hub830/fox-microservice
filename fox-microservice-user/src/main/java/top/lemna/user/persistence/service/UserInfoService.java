package top.lemna.user.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import top.lemna.user.persistence.entity.UserInfo;
import top.lemna.user.persistence.repository.UserInfoRepository;
import top.lemna.user.persistence.service.base.BaseService;

/**
 * 用户管理.
 * 
 * @author hu
 * 
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserInfoService extends BaseService<UserInfo> {

  private final UserInfoRepository repository;
}
