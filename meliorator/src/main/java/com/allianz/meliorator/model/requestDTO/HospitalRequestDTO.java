package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.database.entity.Clinic;
import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalRequestDTO extends BaseRequestDTO {
    private String name;
    private List<Clinic> clinic;
}
