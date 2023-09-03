package allianz.healthtourism.dto.Request;

import allianz.healthtourism.base.BaseRequestDTO;
import allianz.healthtourism.dto.Response.AppointmentDTO;
import allianz.healthtourism.dto.Response.FlightDTO;
import allianz.healthtourism.dto.Response.HotelDTO;
import allianz.healthtourism.entity.Appointment;
import allianz.healthtourism.entity.Flight;
import allianz.healthtourism.entity.Hotel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class TravelPlanRequest extends BaseRequestDTO {

    private Long appointmentId;

    private Long hotelId;

    private Long flightId;
}
