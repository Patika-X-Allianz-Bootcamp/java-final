package allianz.healthtourism.dto.Response;

import allianz.healthtourism.base.BaseDTO;
import allianz.healthtourism.entity.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class HealthServiceDTO extends BaseDTO {

    private String serviceName;

    @JsonIgnore
    private Long appointmentId;
}
