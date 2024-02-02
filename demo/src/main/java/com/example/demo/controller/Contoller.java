package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private String generateToken() {
        return "your_static_token";
    }
}
