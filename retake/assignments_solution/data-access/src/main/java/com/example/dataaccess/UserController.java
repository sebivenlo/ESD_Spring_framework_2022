package com.example.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/fetchAllUsers")
    public List<User> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return "Deleted Successfully";
    }

    @GetMapping("/fetchUserById/{id}")
    public User fetchUserById(@PathVariable("id") Long id) {
        return userService.fetchUserById(id);
    }
}
