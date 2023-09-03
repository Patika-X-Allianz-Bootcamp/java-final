package allianz.healthtourism.dto.Response;

import allianz.healthtourism.base.BaseDTO;
import allianz.healthtourism.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class DoctorDTO extends BaseDTO {

    private String name;

    private String branch;

    @JsonIgnore
    private Long patientId;

    @JsonIgnore
    private Long appointmentId;

}
