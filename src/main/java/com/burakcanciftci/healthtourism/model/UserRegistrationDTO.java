package com.burakcanciftci.healthtourism.model;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.Set;

@Data
public class UserRegistrationDTO extends BaseDTO {
    private String email;
    private String password;
    private Set<String> roles;
}
