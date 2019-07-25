package com.example.loginSystem;

import com.example.loginSystem.DAO.UserDAOImpl;
import com.example.loginSystem.Model.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    UserDAOImpl userDAO;

    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return userDAO.findAll();
    }

    @GetMapping("/user/{username:[a-zA-Z]+}")
    public User getAllUsers(@PathVariable(value="username") String username) {
        return userDAO.findByUsername(username);
    }

    @PostMapping("/user/{username:[a-zA-Z]+}")
    public void modifyUserByUsername(@Valid @RequestBody User user,@PathVariable(value="username") String username) throws Exception {
        userDAO.modifyUserByUsername(user,username);
    }

    @DeleteMapping("/user/{username:[a-zA-Z]+}")
    public void deleteUserByUsername(@PathVariable(value="username") String username) throws Exception {
        userDAO.deleteUserByUsername(username);
    }

    @PostMapping("/register")
    public void addUser(@Valid @RequestBody User user) throws Exception {
        Session session=HibernateUtil.getSessionFactory().openSession();
        String query="SELECT * FROM users WHERE username=\""+user.getUserName()+"\"";
        SQLQuery sqlQuery=session.createSQLQuery(query);
        List<User[]> results= sqlQuery.getResultList();
        if (results.size()>0)
        {
            throw new Exception("Username already exists");

        }
        else userDAO.addUser(user);
    }

    @GetMapping("/user/{id:[0-9]+}")
    public User getAllUsers(@PathVariable(value="id") int id)
    {
        return userDAO.findByID(id);
    }

    @PostMapping("/user/{id:[0-9]+}")
    public void modifyUserById(@Valid @RequestBody User user,@PathVariable(value="id") int id) throws Exception {
        userDAO.modifyUserByID(user,id);
    }

    @DeleteMapping("/user/{id:[0-9]+}")
    public void deleteUserById(@PathVariable(value="id") int id) throws Exception {
        userDAO.deleteUserByID(id);
    }


}
