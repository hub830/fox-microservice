package top.lemna.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import top.lemna.user.security.jwt.FoxJwtTokenEnhancer2;


@Configuration
public class JwtSecurityConfig2 {

  @Bean
  TokenEnhancer jwtTokenEnhancer() {
    return new FoxJwtTokenEnhancer2();
  }
  
}
