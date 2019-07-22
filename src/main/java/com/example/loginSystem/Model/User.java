package com.example.loginSystem.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name="id")
    int id;
    @Column(name="name")
    String name;
    @Column(name="username")
    String username;
    @Column(name="password")
    String password;

    public User() {
        this.id = 0;
        this.name = null;
        this.username = null;
        this.password = null;
    }

    public User(int id,String name, String userName, String password) {
        this.id = id;
        this.name = name;
        this.username = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
