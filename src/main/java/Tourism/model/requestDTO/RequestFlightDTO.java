package Tourism.model.requestDTO;


import Tourism.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RequestFlightDTO extends BaseDTO {

    private String airline;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private BigDecimal price;
    private int availableSeats;
    private List<RequestPatientDTO> patientList;


}
