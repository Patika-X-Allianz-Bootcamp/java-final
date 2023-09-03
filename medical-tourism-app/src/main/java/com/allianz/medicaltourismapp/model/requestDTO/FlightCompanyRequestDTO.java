package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class FlightCompanyRequestDTO extends BaseDTO {

    private String flightCompanyName;
    private String flightCompanyAddress;
    private String flightCompanyPhone;
    private List<FlightRequestDTO> flights;
}
