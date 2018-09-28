package top.lemna.user.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import top.lemna.user.persistence.entity.Privilege;
import top.lemna.user.persistence.repository.PrivilegeRepository;
import top.lemna.user.persistence.service.base.BaseService;

/**
 * 订单管理.
 * 
 * @author hu
 * 
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) 
public class PrivilegeService extends BaseService<Privilege> {

  private final PrivilegeRepository repository;

  public Privilege findByOperation(String operation) {
    return repository.findByOperation(operation);
  }

}
