package com.vitor.springsecurity.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vitor.springsecurity.entities.Role;
import com.vitor.springsecurity.entities.User;
import com.vitor.springsecurity.repository.RoleRepository;
import com.vitor.springsecurity.repository.UserRepository;

import jakarta.transaction.Transactional;

@Configuration
public class AdminUserConfig implements CommandLineRunner {
    
    private RoleRepository roleRepository;

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleRepository roleRepository,
                           UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    
    @Transactional
    @Override
    public void run(String... args) throws Exception {
       var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());

       var userAdmin = userRepository.findByUsername("admin");

       userAdmin.ifPresentOrElse(
            user -> {
                System.out.println("admin already exists");
            },
            () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("123"));
                    user.setRoles(Set.of(roleAdmin));
                    userRepository.save(user);
            }
       
       );
    }
}
