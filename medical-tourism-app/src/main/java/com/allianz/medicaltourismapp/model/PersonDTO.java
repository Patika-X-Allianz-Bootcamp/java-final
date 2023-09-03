package com.allianz.medicaltourismapp.model;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;

import lombok.Data;


@Data
public abstract class PersonDTO extends BaseDTO {
    private String firstname;
    private String lastname;
    private String password;
    private String email;
}
