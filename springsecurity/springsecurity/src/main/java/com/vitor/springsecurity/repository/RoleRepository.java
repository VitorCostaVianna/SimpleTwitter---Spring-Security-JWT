package com.vitor.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitor.springsecurity.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
