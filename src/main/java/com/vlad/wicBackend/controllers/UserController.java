package com.vlad.wicBackend.controllers;

import com.vlad.wicBackend.models.User;
import com.vlad.wicBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception {
        return service.register(user);
    }
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws UsernameNotFoundException {
        return service.login(user);
    }
    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }

}
