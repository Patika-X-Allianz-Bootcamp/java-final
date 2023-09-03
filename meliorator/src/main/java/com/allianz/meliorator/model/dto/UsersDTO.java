package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class UsersDTO extends BaseDTO {
    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private List<RoleDTO> roles;
}
