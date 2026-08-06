package com.anuj.stayeasy.dto.response;

import lombok.Data;

@Data
public class LoginUserResponse {

    private Long id;
    private String name;
    private String email;
    private String role;
    private String message;
    private String token;

}
