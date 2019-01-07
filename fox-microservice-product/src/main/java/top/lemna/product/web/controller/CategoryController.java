package top.lemna.product.web.controller;

import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Add;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.querydsl.core.types.Predicate;
import top.lemna.product.persistence.entity.Category;
import top.lemna.product.persistence.service.CategoryService;
import top.lemna.product.web.command.ProductCategoryCommand;

@RestController
@RequestMapping("productcategory")
public class CategoryController {

  @Autowired
  private CategoryService service;


  @GetMapping(value = "/{id}")
  public ResponseEntity<?> get(@PathVariable("id") BigInteger id) {
    Category category = service.findById(id);
    return new ResponseEntity<Category>(category, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Page<?>> get(@QuerydslPredicate(root = Category.class) Predicate predicate,
      Pageable pageable, @RequestParam MultiValueMap<String, String> parameters) {
    Page<Category> page = service.findAll(predicate, pageable);
    return new ResponseEntity<Page<?>>(page, HttpStatus.OK);
  }

  @PostMapping
  @PreAuthorize("hasAuthority('PRIVILEGE_PRODUCT_CATEGORY_ADD')")
  public ResponseEntity<?> post(
      @RequestBody @Validated(value = {Add.class}) ProductCategoryCommand command//
  ) {
    Category category = service.create(//
        command.getName(), //
        command.getDescribe(), //
        command.getParentId(), //
        command.getProperties()//
    );
    return new ResponseEntity<Category>(category, HttpStatus.OK);
  }

  @PutMapping(value = "/{id}")
  @PreAuthorize("hasAuthority('PRIVILEGE_PRODUCT_CATEGORY_UPDATE')")
  public ResponseEntity<?> put(@PathVariable("id") BigInteger id,
      @RequestBody @Validated ProductCategoryCommand command) {
    Category category =
        service.update(id, command.getName(), command.getDescribe(), command.getParentId());
    return new ResponseEntity<Category>(category, HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  @PreAuthorize("hasAuthority('PRIVILEGE_PRODUCT_CATEGORY_DEL')")
  public ResponseEntity<Void> del(@PathVariable("id") BigInteger id) {
    service.delete(id);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }


}
