package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.util.BaseResponseDTO;
import com.allianz.healthtourism.util.dbutil.BaseEntity;
import lombok.Data;

@Data
public class SeatResponseDTO extends BaseResponseDTO {
    private int seatNo;
    private boolean isAvailable;
    private PatientResponseDTO patient;
}
