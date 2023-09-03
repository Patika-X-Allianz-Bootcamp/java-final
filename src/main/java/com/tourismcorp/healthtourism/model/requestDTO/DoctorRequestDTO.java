package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.model.RoleDTO;
import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class DoctorRequestDTO extends BaseDTO {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private List<RoleDTO> roles;

    private String field;

}
