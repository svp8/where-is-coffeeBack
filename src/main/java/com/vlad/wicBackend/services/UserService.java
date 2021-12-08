package com.vlad.wicBackend.services;

import com.vlad.wicBackend.models.User;
import com.vlad.wicBackend.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User register(User newuser){
        if(newuser!=null){
            User user=userRepo.findByEmail(newuser.getEmail());
            if(user!=null){
                newuser.setRole("USER");
                return userRepo.save(newuser);
            }
        }
        return null;
    }
}
