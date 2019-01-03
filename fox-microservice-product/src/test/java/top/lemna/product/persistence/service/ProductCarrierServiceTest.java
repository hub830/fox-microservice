package top.lemna.product.persistence.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lemna.product.persistence.entity.ProductCarrier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCarrierServiceTest {

  @Autowired
  private ProductCarrierService service;

  private ProductCarrier productCarrier;

  @Before
  public void setup() {
    productCarrier = new ProductCarrier("锦弘霖","深圳市锦弘霖电子设备有限公司是一家专注于金融支付终端研发、生产、销售和服务于一 体的国家高新技术企业。公司从最初的电话支付终端、密码键盘等产品延伸到金融POS终端、 移动支付终端、智能POS支付终端以及全方位的电子支付软、硬件技术服务领域，为行业客户 提供一体化的综合支付解决方案。");
  }

  @Test
  public void testSave() {
    ProductCarrier carrier = service.save(productCarrier);

    assertThat(carrier.getId(), notNullValue());
  }

}
