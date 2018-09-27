package top.lemna.user.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import top.lemna.user.utils.GenericJackson2JsonRedisSerializerEx;


@Configuration
@EnableAutoConfiguration
public class RedisConfig {

  @Bean
  RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
    template.setConnectionFactory(redisConnectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setDefaultSerializer(new GenericJackson2JsonRedisSerializerEx());
    template.setEnableDefaultSerializer(true);
    return template;
  }
}
