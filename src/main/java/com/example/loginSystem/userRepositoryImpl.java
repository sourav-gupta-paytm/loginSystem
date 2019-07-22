//package com.example.loginSystem;
//
//import com.example.loginSystem.Model.User;
//import com.example.loginSystem.Repository.userRepository;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class userRepositoryImpl implements userRepository {
//
//    private RedisTemplate<String,User> redisTemplate;
//    private HashOperations hashOperations;
//
//    public userRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//        hashOperations=redisTemplate.opsForHash();
//    }
//
//    @Override
//    public void save(User user) {
//        hashOperations.put("USER",user.getId(),user);
//    }
//
//    @Override
//    public Map<String,User> findAll() {
//        return hashOperations.entries("USER");
//    }
//
//    @Override
//    public void update(String id, User user) {
//        hashOperations.put("USER",id,user);
//    }
//
//    @Override
//    public void delete(String id) {
//
//    }
//
//    @Override
//    public User findById(String id) {
//        return null;
//    }
//}
