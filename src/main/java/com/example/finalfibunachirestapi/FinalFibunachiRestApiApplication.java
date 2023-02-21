package com.example.finalfibunachirestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
//@EnableCaching
public class FinalFibunachiRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalFibunachiRestApiApplication.class, args);
    }

}
