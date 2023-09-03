package com.patika.healthtourism.model;

import com.patika.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {
    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String photoLink;
}
