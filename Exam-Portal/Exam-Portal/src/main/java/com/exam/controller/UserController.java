package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;
    // Craeting user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("student.jpg");
        //ecoding password with BCryptPasswordEncoder
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        Set<UserRole> userRoleSet = new HashSet<>();
        Role role = new Role();

        role.setRoleId(1L);
        role.setRoleName("STUDENT");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleSet.add(userRole);


        return this.userService.createUser(user,userRoleSet);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){

        this.userService.deleteUser(userId);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }
}
