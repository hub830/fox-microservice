package top.lemna.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients
public class UserApplication {
    
    
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}