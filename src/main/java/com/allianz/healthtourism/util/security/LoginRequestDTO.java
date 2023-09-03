package com.allianz.healthtourism.util.security;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String email;
    private String password;
}
