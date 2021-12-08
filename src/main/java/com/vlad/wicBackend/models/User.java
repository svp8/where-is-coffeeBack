package com.vlad.wicBackend.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Builder
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 14)
    private String username;

    @Column(length=40)
    private String email;

    @Column(length = 16)
    private String password;

    @Column
    private String role;


}
