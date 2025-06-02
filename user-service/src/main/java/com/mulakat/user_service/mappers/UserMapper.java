package com.mulakat.user_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.mulakat.user_service.dtos.request.CreateUserRequest;
import com.mulakat.user_service.dtos.response.UserResponse;
import com.mulakat.user_service.entities.User;

@Mapper
public interface UserMapper {
UserMapper ISNTANCE =Mappers.getMapper(UserMapper.class);
User toEntity(CreateUserRequest createUserRequest);
UserResponse toResponse(User user);
}
