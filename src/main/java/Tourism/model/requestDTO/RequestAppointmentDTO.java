package Tourism.model.requestDTO;


import Tourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestAppointmentDTO extends BaseDTO {

    private LocalDate appoinmentDate;
    private RequestPatientDTO patient;
    private RequestDoctorDTO doctor;
    private int duration;


}
