package top.lemna.user.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import top.lemna.user.persistence.entity.Address;
import top.lemna.user.persistence.repository.AddressRepository;
import top.lemna.user.persistence.service.base.BaseService;

/**
 * 地址簿管理.
 * 
 * @author hu
 * 
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService extends BaseService<Address> {

  private final AddressRepository repository;

}
