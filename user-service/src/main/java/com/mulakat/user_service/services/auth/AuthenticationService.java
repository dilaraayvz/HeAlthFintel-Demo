package com.mulakat.user_service.services.auth;

import com.mulakat.user_service.dtos.request.CreateUserRequest;
import com.mulakat.user_service.dtos.response.AuthResponse;
import com.mulakat.user_service.dtos.response.UserResponse;
import com.mulakat.user_service.entities.User;
import com.mulakat.user_service.repositories.UserRepository;
import com.mulakat.user_service.core.config.JwtService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;  // Şifre doğrulaması için


    public AuthenticationService(UserRepository userRepository, JwtService jwtService,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse authenticate(String email, String rawPassword) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
    
        // Şifre kontrolü (hash karşılaştırması)
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
    
        String token = jwtService.generateToken(user);
    
        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    
        return AuthResponse.builder()
                .accessToken(token)
                .user(userResponse)
                .build();
    }
    public AuthResponse register(CreateUserRequest request) {
    if (userRepository.findByEmail(request.getEmail()) != null) {
        throw new IllegalArgumentException("User already exists");
    }

    User user = new User();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword())); // Şifre hash'le
    user.setAge(request.getAge());
    user.setGender(request.getGender());
    user.setAddress(request.getAddress());
    user.setPhoneNumber(request.getPhoneNumber());

    User savedUser = userRepository.save(user);

    String token = jwtService.generateToken(savedUser);

    UserResponse userResponse = UserResponse.builder()
            .id(savedUser.getId())
            .email(savedUser.getEmail())
            .name(savedUser.getName())
            .age(savedUser.getAge())
            .gender(savedUser.getGender())
            .address(savedUser.getAddress())
            .phoneNumber(savedUser.getPhoneNumber())
            .build();

    return AuthResponse.builder()
            .accessToken(token)
            .user(userResponse)
            .build();
}
    
}
