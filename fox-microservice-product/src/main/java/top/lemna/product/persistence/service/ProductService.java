package top.lemna.product.persistence.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import top.lemna.core.enums.product.ProductStatus;
import top.lemna.product.exception.ProductAlreadyExistException;
import top.lemna.product.exception.ProductNotExistException;
import top.lemna.product.exception.ProductStockNotEnoughException;
import top.lemna.product.persistence.entity.Brand;
import top.lemna.product.persistence.entity.Category;
import top.lemna.product.persistence.entity.Product;
import top.lemna.product.persistence.repository.ProductRepository;
import top.lemna.product.persistence.service.base.BaseService;
import top.lemna.product.web.command.ProductCommand;

/**
 * 产品管理.
 * 
 * @author hu
 * 
 */
@Slf4j
@Service
public class ProductService extends BaseService<Product> {

  @Autowired
  @SuppressWarnings("unused")
  private ProductRepository repository;

  @Autowired
  private MongoTemplate mongoTemplate;

  public Product findByProductNo(String productNo) {
    Optional<Product> o = repository.findByProductNo(productNo);
    return o.orElseThrow(() -> new ProductNotExistException(productNo));
  }

  public Product create(ProductCommand command) {
    // 唯一性检测
    Optional<Product> o = repository.findByProductNo(command.getProductNo());
    if (o.isPresent()) {
      throw new ProductAlreadyExistException(command.getProductNo());
    }
    // 构造产品实例
    Product product = Product.builder()//
        .name(command.getName())//
        .productNo(command.getProductNo())//
        .price(0)//
        .stock(0)//
        .brand(command.getBrand())//
        .category(command.getCategory())//
        .properties(command.getProperties())//
        .brief(command.getBrief())//
        .status(ProductStatus.PUBLISH)//
        .describe(command.getDescribe()).build();

    return save(product);
  }


  /**
   * 销售，减库存
   * 
   * @param commands
   * @return 
   */
  @Transactional
  public Product sale(String productNo, Integer num) {
    Product product = findByProductNo(productNo);
    if (product.getStock() < num) {
      throw new ProductStockNotEnoughException(productNo);
    }
    product.setStock(product.getStock() - num);
    return product = save(product);
  }

  /**
   * 查找话费产品专用 db.getCollection('product').find({"properties" : {"$elemMatch" : {"optionName" : "湖南",
   * "optionName" : "100"}}})
   * 
   * @param province 省
   * @param operator 运营商
   * @param category 分类
   * @return
   */
  public Product find4Hf(String areaNo, Brand carrier, Category category) {

    String regex = "^" + areaNo.substring(0, 2) + "\\d{4}";
    Criteria c_category = Criteria.where("category").is(category);
    Criteria c_operator = Criteria.where("carrier").is(carrier);
    Criteria c_status = Criteria.where("status").is(ProductStatus.PUBLISH);
    Criteria c_properties = Criteria.where("properties")
        .elemMatch(Criteria.where("optionName").regex(regex).and("propertyName").is("区域"));

    // Query query = new Query();
    // query.addCriteria(Criteria.where("properties").elemMatch(Criteria.where("optionName").is(province).and("propertyName").is("区域")).elemMatch(Criteria.where("optionName").is("100").and("propertyName").is("面值")));

    Query query =
        new Query(new Criteria().andOperator(c_category, c_operator, c_properties, c_status));
    List<Product> list = mongoTemplate.find(query, Product.class);
    if (list == null || list.size() > 1) {
      throw new ProductNotExistException(areaNo, carrier, category, ProductStatus.PUBLISH);
    }
    if (list.size() > 1) {
      log.debug("数据库中存在多条相应的产品 areaNo:{}, carrier:{}, category:{}, status:{}", areaNo, carrier,
          category, ProductStatus.PUBLISH);
    }
    return list.get(0);
  }
}
