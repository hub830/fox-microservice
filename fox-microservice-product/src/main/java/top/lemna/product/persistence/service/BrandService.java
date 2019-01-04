package top.lemna.product.persistence.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lemna.product.exception.ProductCarrierNotExistException;
import top.lemna.product.persistence.entity.Brand;
import top.lemna.product.persistence.repository.BrandRepository;
import top.lemna.product.persistence.service.base.BaseService;

/**
 * 运营商管理.
 * 
 * @author hu
 * 
 */
@Service
public class BrandService extends BaseService<Brand> {

  @Autowired
  private BrandRepository repository;

  public Brand findByName(String name)
  {
    Optional<Brand> optional = repository.findByName(name);
    return optional.orElseThrow(() -> new ProductCarrierNotExistException(name)); 
  }
}
