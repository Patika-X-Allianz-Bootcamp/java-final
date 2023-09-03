package Tourism.model.requestDTO;


import Tourism.database.entity.AppointmentEntity;
import Tourism.database.entity.FlightEntity;
import Tourism.database.entity.HospitalEntity;
import Tourism.database.entity.HotelEntity;
import Tourism.model.enums.SexEnum;
import Tourism.util.BaseDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RequestPatientDTO extends BaseDTO {

    private String name;
    private String surname;
    private int age;
    private String illness;
    private SexEnum sex;
    private List<String> symptomList;
    private String report; //needs to initialized with doctor report;
    private boolean hasAppointment;
    private RequestHotelDTO accommodation;
    private RequestFlightDTO flight;
    private RequestHospitalDTO hospital;
    private List<RequestAppointmentDTO> appointmentList;

}
