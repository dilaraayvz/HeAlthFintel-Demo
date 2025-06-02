package com.mulakat.user_service.dtos.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private String address;
    private String phoneNumber;
}
