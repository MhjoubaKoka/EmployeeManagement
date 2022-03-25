package com.example.securitymery.service;


import com.example.securitymery.Model.Role;
import com.example.securitymery.Model.User;
import com.example.securitymery.Repository.RoleRepository;
import com.example.securitymery.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class userServiceIpml implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public User createUser(User user){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        Role roleUser = roleRepository.findByRoleName("User");

        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        user.setPassword(encodedPassword);
        user.setRoles(roles);
        return userRepository.save(user);

    }

    public User findByToken(String token){
        return userRepository.getUserByToken(token);
    }

    @Override
    public Boolean existUserName(String username) {
        return this.userRepository.existsByUserName(username);
    }
}
