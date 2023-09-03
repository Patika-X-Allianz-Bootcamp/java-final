package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.util.BaseDTO;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {
    private String title;
    private String address;
}
