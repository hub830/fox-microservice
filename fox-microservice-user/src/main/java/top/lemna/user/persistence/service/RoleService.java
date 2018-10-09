package top.lemna.user.persistence.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import top.lemna.user.persistence.entity.Role;
import top.lemna.user.persistence.repository.RoleRepository;
import top.lemna.user.persistence.service.base.BaseService;

/**
 * 订单管理.
 * 
 * @author hu
 * 
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleService extends BaseService<Role> {

  private final RoleRepository repository;

  public Optional<Role> findByName(String name) {
    return repository.findByName(name);
  }
}
