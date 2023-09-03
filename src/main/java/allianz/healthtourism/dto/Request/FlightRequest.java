package allianz.healthtourism.dto.Request;

import allianz.healthtourism.base.BaseRequestDTO;
import lombok.Data;

@Data
public class FlightRequest extends BaseRequestDTO {

    private String flightNumber;
    private String departure;
    private String arrival;
}
