package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class Contoller {

    @GetMapping("/health")
    public String health()
    {
        return "healthy";
    }

    
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        String hardcodedUsername = "demoUser";
        String hardcodedPassword = "demoPassword";

        if (loginRequest.getUsername().equals(hardcodedUsername) && loginRequest.getPassword().equals(hardcodedPassword)) {
            String token = generateToken();

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Invalid credentials");

            return ResponseEntity.status(401).body(response);
        }
    }
    
    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout() {

        Map<String, String> response = new HashMap<>();
        response.put("message", "Logout successful");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    public ResponseEntity<Map<String, String>> getUser(@RequestParam String username) {
        if ("demoUser".equals(username)) {
            Map<String, String> response = new HashMap<>();
            response.put("username", username);
            response.put("email", "demoUser@example.com");
            // Add more user details as needed
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "User not found");
            return ResponseEntity.status(404).body(response);
        }
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
