package com.allianz.healthtourism.util.security;

import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class RoleResponseDTO extends BaseResponseDTO {
    private String name;
    private String description;
    private List<UserResponseWithoutRoleDTO> users;
}
