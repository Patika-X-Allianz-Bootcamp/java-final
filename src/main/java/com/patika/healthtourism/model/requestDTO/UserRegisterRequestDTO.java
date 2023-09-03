package com.patika.healthtourism.model.requestDTO;

import com.patika.healthtourism.util.BaseRequestDTO;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserRegisterRequestDTO extends BaseRequestDTO {
    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String photoLink;

}
