package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.Set;

@Data
public class RoleRequestDTO extends BaseDTO {
    private String name;
    private String description;
    private Set<UserRequestDTO> users;
}
