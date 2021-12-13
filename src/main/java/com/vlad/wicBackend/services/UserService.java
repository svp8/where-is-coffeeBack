package com.vlad.wicBackend.services;

import com.vlad.wicBackend.models.User;
import com.vlad.wicBackend.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    public User register(User newuser) throws Exception {
        if (newuser != null) {
            User user = userRepo.findByUsername(newuser.getUsername());
            if (user == null) {
                newuser.setRole("USER");
                newuser.setPassword(new BCryptPasswordEncoder().encode(newuser.getPassword()));
                return userRepo.save(newuser);
            }
        }
        System.out.println(newuser.getUsername());
        throw new Exception("user already exists");
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User login(User user) throws UsernameNotFoundException {

        if (user != null) {
            User test = userRepo.findByUsername(user.getUsername());

            if (test != null) {

                if (new BCryptPasswordEncoder().matches(user.getPassword(), test.getPassword())) {
                    return test;
                }
            } else {
                System.out.println("ss");
                throw new UsernameNotFoundException("problem");
            }
        }

        throw new UsernameNotFoundException("null user");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
