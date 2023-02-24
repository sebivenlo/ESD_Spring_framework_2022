package com.example.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepositoryInterface userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User userDb = userRepository.findById(user.getId()).orElse(null);
        if(userDb == null)
            return null;
        if(Objects.nonNull(user.getFirstname()) && !"".equalsIgnoreCase(user.getFirstname()))
            userDb.setFirstname(user.getFirstname());
        if(Objects.nonNull(user.getLastname()) && !"".equalsIgnoreCase(user.getLastname()))
            userDb.setLastname(user.getLastname());
        if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail()))
            userDb.setEmail(user.getEmail());

        return userRepository.save(userDb);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User fetchUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
