package com.example.dataaccess;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> fetchAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);
    User fetchUserById(Long id);
}
