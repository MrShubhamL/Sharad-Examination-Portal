package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    // Creating new user
    User createUser(User user, Set<UserRole> userRole) throws Exception;

    // Get user by username
    User getUser(String username);

    //Delete user by id
    public void deleteUser(Long userId);

    // getAll User
    List<User> getAllUsers();
}
