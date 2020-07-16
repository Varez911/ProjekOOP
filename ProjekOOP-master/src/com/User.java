/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author userPC
 */
public class User {
    private int id_user;
    private String username, password, level;

    public User() {
    }

    public User(int id_user, String username, String password, String level) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.level = level;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", username=" + username + ", password=" + password + ", level=" + level + '}';
    }
    
}
