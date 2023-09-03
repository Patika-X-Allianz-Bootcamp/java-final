package allianz.healthtourism.dto.Response;

import allianz.healthtourism.base.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HotelDTO extends BaseDTO {

    private String name;
    private String location;

    private boolean isConfirmed;  // Rezervasyon onay durumu

    private boolean isInvalid;  // Rezervasyon geçerlilik durumu

    private LocalDateTime createdAt = LocalDateTime.now();
}
