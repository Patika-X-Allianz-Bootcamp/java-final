package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

@Data
public class CityRequestDTO extends BaseRequestDTO {
    private String name;
    private String airport;
}
