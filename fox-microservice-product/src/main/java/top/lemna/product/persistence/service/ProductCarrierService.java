package top.lemna.product.persistence.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lemna.product.exception.ProductCarrierNotExistException;
import top.lemna.product.persistence.entity.ProductCarrier;
import top.lemna.product.persistence.repository.ProductCarrierRepository;
import top.lemna.product.persistence.service.base.BaseService;

/**
 * 运营商管理.
 * 
 * @author hu
 * 
 */
@Service
public class ProductCarrierService extends BaseService<ProductCarrier> {

  @Autowired
  private ProductCarrierRepository repository;

  public ProductCarrier findByName(String name)
  {
    Optional<ProductCarrier> optional = repository.findByName(name);
    return optional.orElseThrow(() -> new ProductCarrierNotExistException(name)); 
  }
}
