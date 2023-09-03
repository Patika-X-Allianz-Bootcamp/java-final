package com.allianz.healthtourism.util.security;

import com.allianz.healthtourism.util.BaseRequestDTO;
import lombok.Data;

@Data
public class UserRequestDTO extends BaseRequestDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String photoLink;
    //    private ProfileRequestDTO profileRequestDTO;
}
