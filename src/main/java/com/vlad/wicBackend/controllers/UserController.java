package com.vlad.wicBackend.controllers;

import com.vlad.wicBackend.models.User;
import com.vlad.wicBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception {
        return service.register(user);
    }
}
