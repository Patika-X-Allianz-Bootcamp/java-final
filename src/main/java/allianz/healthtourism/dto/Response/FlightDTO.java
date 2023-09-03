package allianz.healthtourism.dto.Response;

import allianz.healthtourism.base.BaseDTO;
import lombok.Data;

@Data
public class FlightDTO extends BaseDTO {

    private String flightNumber;
    private String departure;
    private String arrival;
}
