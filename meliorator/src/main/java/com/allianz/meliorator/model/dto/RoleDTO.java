package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.database.entity.Users;
import com.allianz.meliorator.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class RoleDTO extends BaseDTO {
    private String name;
    private String description;
    private List<UsersDTO> users;
}
