package com.allianz.healthtourism.util.security;

import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

@Data
public class RoleWithoutUsersResponseDTO extends BaseResponseDTO {
    private String name;
    private String description;
}
