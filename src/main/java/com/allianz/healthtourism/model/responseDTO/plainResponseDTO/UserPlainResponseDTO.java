package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.util.BaseResponseDTO;
import com.allianz.healthtourism.util.security.RoleResponseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserPlainResponseDTO extends BaseResponseDTO {
    private String email;
    private String firstName;
    private String lastName;
}
