package com.github.diegopacheco.sandboxspring;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.reactive.RedisStringReactiveCommands;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.github.diegopacheco.sandboxspring")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RedisClient redisClient() {
        return RedisClient.create("redis://localhost:6379/0");
    }

	@Bean
	public StatefulRedisConnection<String, String> statefulRedisConnection(RedisClient redisClient) {
        return redisClient.connect();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Spring Boot 2.0 working! ");
        };
    }
}

