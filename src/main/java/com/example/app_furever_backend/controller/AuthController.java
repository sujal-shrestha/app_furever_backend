package com.example.app_furever_backend.controller;

import com.example.app_furever_backend.pojo.User;
import com.example.app_furever_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User loginRequest) {
        User user = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);  // Return 200 OK with user data
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);  // Return 401 Unauthorized
        }
    }
}
