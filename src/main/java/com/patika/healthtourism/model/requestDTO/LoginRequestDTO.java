package com.patika.healthtourism.model.requestDTO;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}
