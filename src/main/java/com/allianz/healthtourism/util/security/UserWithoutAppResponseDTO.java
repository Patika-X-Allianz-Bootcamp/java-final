package com.allianz.healthtourism.util.security;

import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserWithoutAppResponseDTO extends BaseResponseDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String photoLink;
    private boolean isEnable;
    //    private ProfileResponseDTO profile;
    private Set<RoleWithoutUsersResponseDTO> roles = new HashSet<>();
}
