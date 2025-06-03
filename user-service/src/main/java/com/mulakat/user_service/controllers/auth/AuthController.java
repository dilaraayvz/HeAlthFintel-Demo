package com.mulakat.user_service.controllers.auth;

import com.mulakat.user_service.dtos.request.CreateUserRequest;
import com.mulakat.user_service.dtos.request.LoginRequest;
import com.mulakat.user_service.dtos.response.AuthResponse;
import com.mulakat.user_service.services.auth.AuthenticationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authenticationService.authenticate(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody CreateUserRequest request) {
    AuthResponse response = authenticationService.register(request);
    return ResponseEntity.ok(response);
}

}