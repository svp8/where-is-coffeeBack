package com.vlad.wicBackend.repos;

import com.vlad.wicBackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    public User findByEmail(String email);
}
