package top.lemna.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import top.lemna.security.UidGenerator2;

//@Configuration
//@EnableConfigurationProperties(UidProperties.class)
//@PropertySource(value = "classpath:uidGenerator.properties")
public class UidGeneratorConfig {


	@Bean
	public UidGenerator2 uidGenerator2()
	{
		UidGenerator2 cachedUidGenerator = new UidGenerator2();
		return cachedUidGenerator;
	}
}
