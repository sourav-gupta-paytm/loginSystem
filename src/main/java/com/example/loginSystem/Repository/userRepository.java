package com.example.loginSystem.Repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

//
import com.example.loginSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//
//public interface userRepository  {
//    void save(User user);
//    Map<String,User> findAll();
//    void update(String id,User user);
//    void delete(String id);
//    User findById(String id);
//}
public interface userRepository extends JpaRepository<User,String>{

}