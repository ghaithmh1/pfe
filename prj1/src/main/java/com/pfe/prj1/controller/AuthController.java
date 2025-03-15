package com.pfe.prj1.controller;

import com.pfe.prj1.model.LoginRequest;
import com.pfe.prj1.model.Utilisateur;
import com.pfe.prj1.security.JwtUtil;
import com.pfe.prj1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Utilisateur signup(@RequestBody Utilisateur utilisateur) {
        return userService.signup(utilisateur);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        
        if (isAuthenticated) {
            String role = userService.getRoleByEmail(loginRequest.getEmail());
            String token = JwtUtil.generateToken(loginRequest.getEmail(), role);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}