package com.allianz.patienttourism.util.security;


import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

import java.util.Set;
@Data
public class UserRequestDTO extends BaseRequestDTO {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Long roleId;

}
