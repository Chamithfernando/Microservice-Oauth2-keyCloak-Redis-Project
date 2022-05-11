package redis.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
public class RedisSpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisSpringBootExampleApplication.class, args);
	}

}
