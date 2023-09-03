package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.FlightPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.SeatPlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import com.allianz.healthtourism.util.dbutil.BaseEntity;
import lombok.Data;

@Data
public class PlaneTicketResponseDTO extends BaseResponseDTO {
    private FlightForTicketResponseDTO flight;
    private SeatPlainResponseDTO seat;
    private PatientPlainResponseDTO patient;
}
