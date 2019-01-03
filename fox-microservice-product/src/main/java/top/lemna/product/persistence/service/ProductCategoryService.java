package top.lemna.product.persistence.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lemna.core.exception.RecordAlreadyExistException;
import top.lemna.product.exception.ProductCarrierNotExistException;
import top.lemna.product.persistence.entity.ProductCategory;
import top.lemna.product.persistence.entity.ProductCategoryProperty;
import top.lemna.product.persistence.repository.ProductCategoryRepository;
import top.lemna.product.persistence.service.base.BaseService;

/**
 * 产品分类管理.
 * 
 * @author hu
 * 
 */
@Service
public class ProductCategoryService extends BaseService<ProductCategory> {

  @Autowired
  private ProductCategoryRepository repository;

  public ProductCategory findByName(String name)
  {
    Optional<ProductCategory> optional = repository.findByName(name);
    return optional.orElseThrow(() -> new ProductCarrierNotExistException(name)); 
  }
  
  public ProductCategory create(String name, String describe, Long parentId,List<ProductCategoryProperty> properties) {
    Optional<ProductCategory> optional = repository.findByName(name);
    if (optional.isPresent()) {
      Map<String, String> params = new HashMap<String, String>();
      params.put("name", name);
      throw new RecordAlreadyExistException(params);

    }
    ProductCategory category = new ProductCategory(name, parentId,properties);
    category.setDescribe(describe);
    return save(category);
  }


  public ProductCategory update(BigInteger id, String name, String describe, Long parentId) {
    ProductCategory category = findById(id);
    if (name != null) {
      category.setName(name);
    }
    if (describe != null) {
      category.setDescribe(describe);
    }
    if (parentId != null) {
      category.setParentId(parentId);

    }
    return save(category);
  }
}
