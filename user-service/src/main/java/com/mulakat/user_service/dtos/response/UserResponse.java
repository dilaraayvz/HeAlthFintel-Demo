package com.mulakat.user_service.dtos.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String address;
    private String phoneNumber;
    private LocalDateTime createdAt;
}
