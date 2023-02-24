package com.example.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class UserServiceImpl implements UserService{
    //TODO implement the methods

    private UserRepositoryInterface userRepository;

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<User> fetchAllUsers() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User fetchUserById(Long id) {
        return null;
    }

}
