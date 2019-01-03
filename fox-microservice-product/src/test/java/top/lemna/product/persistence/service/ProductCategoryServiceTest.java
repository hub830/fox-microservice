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
import top.lemna.product.persistence.entity.ProductCategory;
import top.lemna.product.persistence.entity.ProductCategoryProperty;
import top.lemna.product.persistence.entity.ProductCategoryPropertyOption;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceTest {

  @Autowired
  private ProductCategoryService productCategoryService;

  private ProductCategory productCategory;

  @Before
  public void setup() {
    String name = "POS机";
    Long parentId = 0L;
    List<ProductCategoryProperty> properties = new ArrayList<>();
    List<ProductCategoryPropertyOption> options = new ArrayList<>();
    ProductCategoryPropertyOption option_write = new ProductCategoryPropertyOption("白色");
    ProductCategoryPropertyOption option_black = new ProductCategoryPropertyOption("黑色");
    ProductCategoryPropertyOption option_blue = new ProductCategoryPropertyOption("蓝色");
    options.add(option_write);
    options.add(option_black);
    options.add(option_blue);
    ProductCategoryProperty property = new ProductCategoryProperty("颜色", options);
    properties.add(property);
    productCategory = new  ProductCategory(name ,parentId,properties);
  }

  @Test
  public void testSave() {
    productCategory = productCategoryService.save(productCategory);
    assertThat(productCategory.getId(),notNullValue());
  }

}
