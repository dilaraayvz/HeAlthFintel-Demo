package com.mulakat.user_service.services.abstracts;


import java.util.List;
import com.mulakat.user_service.dtos.request.CreateUserRequest;
import com.mulakat.user_service.dtos.response.UserResponse;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    void deleteUser(Long id);
}
