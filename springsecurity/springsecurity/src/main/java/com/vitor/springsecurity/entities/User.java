package com.vitor.springsecurity.entities;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
    
    private static final String TABLE_NAME = "tb_users";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String username;

    private String password;

    private Set<Role> roles;
}
