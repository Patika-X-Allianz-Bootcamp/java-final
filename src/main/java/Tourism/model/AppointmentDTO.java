package Tourism.model;


import Tourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentDTO extends BaseDTO {

    private LocalDate appoinmentDate;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private int duration;


}
