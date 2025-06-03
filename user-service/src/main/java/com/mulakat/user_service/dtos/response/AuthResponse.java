package com.mulakat.user_service.dtos.response;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class AuthResponse {
    private String accessToken;

    @Builder.Default
    private String tokenType = "Bearer";

    private UserResponse user;
}
