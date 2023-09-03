package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDTO extends BaseDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String photoLink;
    private boolean isEnable;
    private Set<RoleResponseDTO> roles;
}
