package com.baidu.fsg.uid.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.baidu.fsg.uid.UidGenerator;
import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.baidu.fsg.uid.properties.UidProperties;
import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;

@Configuration
@EnableConfigurationProperties(UidProperties.class)
@PropertySource(value = "classpath:uidGenerator.properties")
public class UidGeneratorConfig {

	@Bean
	DisposableWorkerIdAssigner disposableWorkerIdAssigner()
	{
		return new DisposableWorkerIdAssigner();
	}
	
	@Bean
	public UidGenerator uidGenerator()
	{
		CachedUidGenerator cachedUidGenerator = new CachedUidGenerator();
		cachedUidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner());
		return cachedUidGenerator;
	}
}
