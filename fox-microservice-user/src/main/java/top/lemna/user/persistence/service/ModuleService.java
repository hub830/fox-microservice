package top.lemna.user.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import top.lemna.user.persistence.entity.Module;
import top.lemna.user.persistence.repository.ModuleRepository;
import top.lemna.user.persistence.service.base.BaseService;

/**
 * 订单管理.
 * 
 * @author hu
 * 
 */
@Service
@SuppressWarnings("unused")
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) 
public class ModuleService extends BaseService<Module> {

  private final ModuleRepository repository;



}
