package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CityDTO extends BaseDTO {
    private String name;
    private String airport;
}
