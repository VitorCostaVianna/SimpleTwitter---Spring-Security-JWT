package com.vitor.springsecurity.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vitor.springsecurity.controller.dto.CreateUserDto;
import com.vitor.springsecurity.entities.Role;
import com.vitor.springsecurity.entities.User;
import com.vitor.springsecurity.repository.RoleRepository;
import com.vitor.springsecurity.repository.UserRepository;

import jakarta.transaction.Transactional;

@RestController
public class UserController {
    
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, 
                        RoleRepository roleRepository, 
                        BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    @PostMapping("/users")
    public ResponseEntity<Void> newUser(@RequestBody CreateUserDto userDto){

        var basicRole = roleRepository.findByName(Role.Values.BASIC.name());


        var  userFromDb = userRepository.findByUsername(userDto.username());
        if (userFromDb.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "User already exists");
        }

        var user = new User();
        user.setUsername(userDto.username());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setRoles(Set.of(basicRole));

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
