package top.lemna.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baidu.fsg.uid.UidGenerator;

import top.lemna.account.AccountApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
public class AccountApplicationTest {
	
	@Autowired
	UidGenerator uidGenerator;
	
	@Test
	public void test() {
		System.out.println("----------------------------------");
        long uid = uidGenerator.getUID();
        String parsedInfo = uidGenerator.parseUID(uid);
        System.out.println(Thread.currentThread().getName() + " No." + uid + " >>> " + parsedInfo);
	}

}
