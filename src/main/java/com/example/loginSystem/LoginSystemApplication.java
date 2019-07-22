package com.example.loginSystem;

import com.example.loginSystem.Model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LoginSystemApplication {

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory(){
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    RedisTemplate<String, User> redisTemplate(){
//        RedisTemplate<String,User> redisTemplate=new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        return redisTemplate;
//    }

    public static void main(String[] args) {
        SpringApplication.run(LoginSystemApplication.class, args);
    }

}
