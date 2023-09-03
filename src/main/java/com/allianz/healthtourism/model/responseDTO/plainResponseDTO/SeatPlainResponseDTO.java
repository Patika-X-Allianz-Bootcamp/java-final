package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

@Data
public class SeatPlainResponseDTO extends BaseResponseDTO {
    private int seatNo;
    private boolean isAvailable;
}
