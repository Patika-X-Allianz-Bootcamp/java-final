package com.allianz.medicaltourismapp.model;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;

import lombok.Data;
import java.util.List;

@Data
public class FlightCompanyDTO extends BaseDTO {

    private String flightCompanyName;
    private String flightCompanyAddress;
    private String flightCompanyPhone;
    private List<FlightDTO> flightCodes;
}
