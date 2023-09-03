package com.allianz.healthtourism.util.security;

import lombok.Data;

@Data
public class UserResponseWithoutRoleDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String photoLink;
    private boolean isEnable;
//    private ProfileResponseDTO profile;
}
