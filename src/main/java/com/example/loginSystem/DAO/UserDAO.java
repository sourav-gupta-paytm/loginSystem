package com.example.loginSystem.DAO;

import com.example.loginSystem.Model.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();
    public User findByID(int id);
    public User findByUsername(String username);
    public void addUser(User user);
    public void modifyUserByID(User user,int id);
    public void modifyUserByUsername(User user,String username);
    public void deleteUserByID(int id);
    public void deleteUserByUsername(String username);

}
