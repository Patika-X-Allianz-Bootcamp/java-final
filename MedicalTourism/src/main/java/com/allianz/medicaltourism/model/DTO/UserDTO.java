package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Data
public class UserDTO extends BaseDTO {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private boolean isEnable;
    private Set<RoleDTO> roles;


    public UserDTO() {
        isEnable = false;
    }
    }
