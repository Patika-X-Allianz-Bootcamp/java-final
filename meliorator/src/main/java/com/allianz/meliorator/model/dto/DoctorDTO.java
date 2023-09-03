package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;
@Data
public class DoctorDTO extends BaseDTO {
    private String name;
    private String surname;
}
