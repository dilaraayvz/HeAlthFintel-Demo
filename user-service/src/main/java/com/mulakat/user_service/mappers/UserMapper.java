package com.mulakat.user_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mulakat.user_service.dtos.UserDTO;
import com.mulakat.user_service.entities.User;

@Mapper
public interface UserMapper {
UserMapper ISNTANCE =Mappers.getMapper(UserMapper.class);
UserDTO toDTO(User user);
User toEntity(UserDTO userDTO);
}
