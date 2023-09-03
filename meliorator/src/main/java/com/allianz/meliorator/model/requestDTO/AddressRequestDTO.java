package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

@Data
public class AddressRequestDTO extends BaseRequestDTO {
    private String title;
    private String address;
}
