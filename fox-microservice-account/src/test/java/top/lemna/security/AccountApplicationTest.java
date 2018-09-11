package top.lemna.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import top.lemna.account.AccountApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
public class AccountApplicationTest {

	@Test
	public void test() {
		System.out.println("----------------------------------");
	}

}
