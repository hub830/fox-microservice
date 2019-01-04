package top.lemna.product.persistence.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lemna.core.enums.product.ProductStatus;
import top.lemna.product.persistence.entity.Brand;
import top.lemna.product.persistence.entity.Category;
import top.lemna.product.persistence.entity.CategoryProperties;
import top.lemna.product.persistence.entity.Product;
import top.lemna.product.persistence.entity.ProductProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

  @Autowired
  private ProductService productService;
  @Autowired
  private ProductCategoryService categoryService;
  @Autowired
  private BrandService brandService;

  private Product product;

  @Before
  public void setup() {

    String name = "M60";
    String productNo = "POS|M60|WRITE";

    Brand brand = brandService.findByName("锦弘霖");
    Category category = categoryService.findByName("POS机");
    Set<CategoryProperties> categoryProperties = category.getProperties();
    CategoryProperties cProperty = categoryProperties.iterator().next();
    String option = cProperty.getOptions().iterator().next();

    Set<ProductProperties> properties = new HashSet<>();
    ProductProperties pProperty = new ProductProperties(cProperty.getName(), option);
    properties.add(pProperty);

    product = Product.builder()//
        .name(name)//
        .productNo(productNo)//
        .price(100)//
        .stock(99)//
        .brand(brand)//
        .category(category)//
        .properties(properties)//
        .brief("POS机")//
        .status(ProductStatus.PUBLISH)//
        .describe("POS机")//
        .build();

  }

  @Test
  public void testCreate() {
    product = productService.save(product);
    assertThat(product.getId(), notNullValue());
  }

}
