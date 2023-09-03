package com.healthtourism.healthtourism.model.RequestDTO;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}
