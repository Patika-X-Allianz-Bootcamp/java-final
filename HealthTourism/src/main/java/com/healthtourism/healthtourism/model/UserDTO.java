package com.healthtourism.healthtourism.model;

import com.healthtourism.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
public class UserDTO extends BaseDTO {

        private String username;
        private String email;
        private String firstName;
        private String lastName;
        private String password;
        private String photoLink;
        private boolean isEnable;
        private Set<RoleDTO> roles = new HashSet<>();

}
