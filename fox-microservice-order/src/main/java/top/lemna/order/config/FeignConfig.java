package top.lemna.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.RequestInterceptor;
import top.lemna.order.feign.interceptor.OAuth2FeignRequestInterceptor;


@Configuration
public class FeignConfig {

  @Bean
  public RequestInterceptor oauth2FeignRequestInterceptor() {
    return new OAuth2FeignRequestInterceptor();
  }

}
