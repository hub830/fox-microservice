package top.lemna.product.web.controller;

import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.querydsl.core.types.Predicate;
import top.lemna.core.validation.group.Add;
import top.lemna.product.persistence.entity.Brand;
import top.lemna.product.persistence.entity.Category;
import top.lemna.product.persistence.entity.Product;
import top.lemna.product.persistence.service.BrandService;
import top.lemna.product.persistence.service.ProductCategoryService;
import top.lemna.product.persistence.service.ProductService;
import top.lemna.product.web.command.ProductCommand;

@RestController
@RequestMapping("product")
public class ProductController {

  @Autowired
  private ProductService service;

  @Autowired
  private BrandService brandService;

  @Autowired
  private ProductCategoryService productCategoryService;


  @GetMapping(value = "product/{id}")
  public ResponseEntity<?> get(@PathVariable("id") Product product) {
    // Product product = service.findById(id);
    return new ResponseEntity<Product>(product, HttpStatus.OK);
  }

  @GetMapping(value = "product")
  public ResponseEntity<Page<?>> get(@QuerydslPredicate(root = Product.class) Predicate predicate,
      Pageable pageable, @RequestParam MultiValueMap<String, String> parameters) {
    Page<Product> page = service.findAll(predicate, pageable);
    return new ResponseEntity<Page<?>>(page, HttpStatus.OK);
  }

  @PostMapping(value = "product")
  public ResponseEntity<?> post(
      @RequestBody @Validated(value = {Add.class}) ProductCommand command) {
    // String name, String brief, String describe, Long faceValue, Long operatorId, Long categoryId
    Product product = service.create(command);
    return new ResponseEntity<Product>(product, HttpStatus.OK);
  }
  /*
   * @PatchMapping(value = "/{id}") public ResponseEntity<?> put(@RequestBody @Validated
   * ProductCommand command) { Product product = service.findById(command.getId());
   * BeanUtils.copyPropertiesIgnoreNull(command, product); product = service.save(product); return
   * new ResponseEntity<Product>(product, HttpStatus.OK); }
   */

  @PatchMapping(value = "product/{id}")
  public ResponseEntity<?> put(@RequestBody ProductCommand command) {
    Product product = service.findById(command.getId());
    // BeanUtils.copyPropertiesIgnoreNull(command, product);
    product = service.save(product);
    return new ResponseEntity<Product>(product, HttpStatus.OK);
  }

  @DeleteMapping(value = "product/{id}")
  public ResponseEntity<Void> del(@PathVariable("id") BigInteger id) {
    service.delete(id);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @GetMapping("hf")
  public ResponseEntity<?> findHfProduct(String areaNo, String carrierName) {
    Brand brand = brandService.findByName(carrierName);
    Category category = productCategoryService.findByName("话费");
    Product product = service.find4Hf(areaNo, brand, category);
    return new ResponseEntity<Product>(product, HttpStatus.OK);
  }

}
