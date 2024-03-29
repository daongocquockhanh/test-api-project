package com.api.user.management.controller;

import com.api.user.management.dto.LoginDto;
import com.api.user.management.dto.UserRegistrationDto;
import com.api.user.management.dto.AuthenticationResponse;
import com.api.user.management.model.User;
import com.api.user.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        User user = userService.register(registrationDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        AuthenticationResponse response = userService.login(loginDto.getEmail(), loginDto.getPassword());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}