package top.lemna.product.persistence.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lemna.core.enums.product.ProductStatus;
import top.lemna.product.persistence.entity.Product;
import top.lemna.product.persistence.entity.ProductCarrier;
import top.lemna.product.persistence.entity.ProductCategory;
import top.lemna.product.persistence.entity.ProductCategoryProperty;
import top.lemna.product.persistence.entity.ProductCategoryPropertyOption;
import top.lemna.product.persistence.entity.ProductProperty;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

  @Autowired
  private ProductService productService;
  @Autowired
  private ProductCategoryService categoryService;
  @Autowired
  private ProductCarrierService carrierService;

  private Product product;

  @Before
  public void setup() {

    String name = "M60";
    String productNo = "POS|M60|WRITE";

    ProductCarrier carrier = carrierService.findByName("锦弘霖");
    ProductCategory category = categoryService.findByName("POS机");
    List<ProductCategoryProperty> list = category.getProperties();
    ProductCategoryProperty categoryProperty = list.get(0);
    ProductCategoryPropertyOption option = categoryProperty.getOptions().get(0);

    List<ProductProperty> properties = new ArrayList<>();
    ProductProperty property = new ProductProperty(categoryProperty.getName(), option.getName());
    properties.add(property);

    product = Product.builder()//
        .name(name)//
        .productNo(productNo)//
        .price(100)//
        .stock(99)//
        .carrier(carrier)//
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
