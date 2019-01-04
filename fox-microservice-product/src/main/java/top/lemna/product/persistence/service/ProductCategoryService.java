package top.lemna.product.persistence.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lemna.core.exception.RecordAlreadyExistException;
import top.lemna.product.exception.ProductCarrierNotExistException;
import top.lemna.product.persistence.entity.Category;
import top.lemna.product.persistence.entity.CategoryProperties;
import top.lemna.product.persistence.repository.CategoryRepository;
import top.lemna.product.persistence.service.base.BaseService;

/**
 * 产品分类管理.
 * 
 * @author hu
 * 
 */
@Service
public class ProductCategoryService extends BaseService<Category> {

  @Autowired
  private CategoryRepository repository;

  public Category findByName(String name) {
    Optional<Category> optional = repository.findByName(name);
    return optional.orElseThrow(() -> new ProductCarrierNotExistException(name));
  }

  public Category create(String name, String describe, Long parentId,
      Set<CategoryProperties> properties) {
    Optional<Category> optional = repository.findByName(name);
    if (optional.isPresent()) {
      Map<String, String> params = new HashMap<String, String>();
      params.put("name", name);
      throw new RecordAlreadyExistException(params);

    }
    Category category = new Category(name, parentId, properties);
    category.setDescribe(describe);
    return save(category);
  }


  public Category update(BigInteger id, String name, String describe, Long parentId) {
    Category category = findById(id);
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
