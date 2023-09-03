package allianz.healthtourism.dto.Request;

import allianz.healthtourism.base.BaseRequestDTO;
import allianz.healthtourism.dto.Response.AppointmentDTO;
import allianz.healthtourism.dto.Response.PatientDTO;
import allianz.healthtourism.entity.Appointment;
import allianz.healthtourism.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;


@Data
public class DoctorRequest extends BaseRequestDTO {

    private String name;

    private String branch;

    @JsonIgnore
    private List<PatientDTO> patients;

    @JsonIgnore
    private List<AppointmentDTO> appointments;


}
