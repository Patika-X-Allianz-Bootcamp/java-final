package allianz.healthtourism.dto.Request;

import allianz.healthtourism.base.BaseRequestDTO;
import allianz.healthtourism.dto.Response.AppointmentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class HealthServiceRequest extends BaseRequestDTO {

    private String serviceName;

    @JsonIgnore
    private List<AppointmentDTO> appointments;
}
