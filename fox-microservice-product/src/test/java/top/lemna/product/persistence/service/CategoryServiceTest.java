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
import top.lemna.product.persistence.entity.Category;
import top.lemna.product.persistence.entity.CategoryProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

  @Autowired
  private CategoryService productCategoryService;

  private Category productCategory;

  @Before
  public void setup() {
    String name = "POS机";
    Long parentId = 0L;
    Set<CategoryProperties> properties = new HashSet<>();
    Set<String> options = new HashSet<>();
    options.add("白色");
    options.add("黑色");
    options.add("蓝色");
    CategoryProperties property = new CategoryProperties("颜色", options);
    properties.add(property);
    productCategory = new Category(name, parentId, properties);
  }

  @Test
  public void testSave() {
    productCategory = productCategoryService.save(productCategory);
    assertThat(productCategory.getId(), notNullValue());
  }

}
