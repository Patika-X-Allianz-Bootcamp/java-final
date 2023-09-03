package allianz.healthtourism.dto.Request;

import allianz.healthtourism.base.BaseRequestDTO;
import lombok.Data;

@Data
public class ExaminationRequest extends BaseRequestDTO {

    private String notes;
}
