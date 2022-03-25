package com.example.securitymery.service;


import com.example.securitymery.Model.User;

public interface UserService {
    public User createUser(User user);
    public User findByToken(String token);
    public Boolean existUserName(String username);
}
