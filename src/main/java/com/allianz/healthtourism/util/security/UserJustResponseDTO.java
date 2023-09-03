package com.allianz.healthtourism.util.security;

import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

@Data
public class UserJustResponseDTO extends BaseResponseDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String photoLink;
    private boolean isEnable;
}
