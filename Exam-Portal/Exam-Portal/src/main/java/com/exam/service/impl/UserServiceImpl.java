package com.exam.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    // Creating new user (Save new user in DB)
    @Override
    public User createUser(User user, Set<UserRole> userRole) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User is already exist!.");
            throw new Exception("User already present! Please try again!");
        }
        else{
            // User create
            for(UserRole ur:userRole){
                roleRepository.save(ur.getRole());
            }
            user.getUserRole().addAll(userRole);
            local = this.userRepository.save(user);

        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
