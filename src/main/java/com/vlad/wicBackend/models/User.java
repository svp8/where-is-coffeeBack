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

    @Column(length = 14,nullable = false)
    private String username;

    @Column(length=40,nullable = false)
    private String email;

    @Column(length = 255,nullable = false)
    private String password;

    @Column
    private String role;


}
