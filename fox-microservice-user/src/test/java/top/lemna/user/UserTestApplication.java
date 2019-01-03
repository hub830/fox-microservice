package top.lemna.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.lemna.security.app.properties.SecurityProperties;
import top.lemna.security.app.validate.code.ValidateCodeGenerator;
import top.lemna.user.web.controller.ImageCodeGenerator;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@Configuration
public class UserTestApplication {

  @Autowired
  private SecurityProperties securityProperties;

  @Bean
  public ValidateCodeGenerator imageValidateCodeGenerator() {
    ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
    codeGenerator.setSecurityProperties(securityProperties);
    return codeGenerator;
  }

  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }

}
