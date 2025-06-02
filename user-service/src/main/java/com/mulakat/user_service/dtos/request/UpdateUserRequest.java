package com.mulakat.user_service.dtos.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
}