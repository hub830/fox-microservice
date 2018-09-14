package top.lemna.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients
public class OrderApplication {
    
    
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}