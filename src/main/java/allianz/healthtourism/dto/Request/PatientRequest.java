package allianz.healthtourism.dto.Request;

import allianz.healthtourism.base.BaseRequestDTO;
import allianz.healthtourism.dto.Response.AppointmentDTO;
import allianz.healthtourism.dto.Response.DoctorDTO;
import allianz.healthtourism.entity.Appointment;
import allianz.healthtourism.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class PatientRequest extends BaseRequestDTO {

    private String name;

    @JsonIgnore
    private Long doctorId;

    @JsonIgnore
    private Long appointmentId;
}
