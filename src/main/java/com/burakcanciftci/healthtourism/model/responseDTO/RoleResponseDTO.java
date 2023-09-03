package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.Set;

@Data
public class RoleResponseDTO extends BaseDTO {
    private String name;
    private String description;
    private Set<UserResponseDTO> users;
}
