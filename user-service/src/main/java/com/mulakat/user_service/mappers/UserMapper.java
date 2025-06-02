package com.mulakat.user_service.mappers;

import org.mapstruct.Mapper;
import com.mulakat.user_service.dtos.request.CreateUserRequest;
import com.mulakat.user_service.dtos.response.UserResponse;
import com.mulakat.user_service.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserRequest createUserRequest);
    UserResponse toResponse(User user);
}
