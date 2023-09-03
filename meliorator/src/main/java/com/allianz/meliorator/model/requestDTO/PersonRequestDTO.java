package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.model.enums.SexTypeEnum;
import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

import java.util.Date;
@Data
public class PersonRequestDTO extends BaseRequestDTO {
    private String name;
    private String surname;
    private String password;
    private String identityNumber;
    private SexTypeEnum sexTypeEnum;
    private Date birthdate;
    private AddressRequestDTO addressRequestDTO;
    private String phoneNumber;
    private String email;

}
