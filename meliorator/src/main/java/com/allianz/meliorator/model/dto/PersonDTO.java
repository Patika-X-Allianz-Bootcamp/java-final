package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.model.enums.SexTypeEnum;
import com.allianz.meliorator.util.BaseDTO;
import lombok.Data;

import java.util.Date;
@Data
public class PersonDTO extends BaseDTO {
    private String name;
    private String surname;
    private String password;
    private String identityNumber;
    private SexTypeEnum sexTypeEnum;
    private Date birthdate;
    private AddressDTO addressDTO;
    private String phoneNumber;
    private String email;

}
