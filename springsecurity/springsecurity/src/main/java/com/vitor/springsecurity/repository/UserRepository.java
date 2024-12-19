package com.vitor.springsecurity.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitor.springsecurity.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {   
}
