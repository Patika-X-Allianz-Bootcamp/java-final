package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.model.dto.RoleDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class UsersRequestDTO extends BaseRequestDTO {
    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private List<RoleRequestDTO> roles;
}
