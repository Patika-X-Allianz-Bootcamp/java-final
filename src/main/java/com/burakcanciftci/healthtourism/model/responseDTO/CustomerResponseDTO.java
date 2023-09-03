package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerResponseDTO extends BaseDTO {
    String name;
    String surname;
    String governmentID;
    List<ExaminationResponseDTO> examinationList = new ArrayList<>();
    List<RoomReservationResponseDTO> roomReservationList = new ArrayList<>();
    List<SeatReservationResponseDTO> seatReservationList = new ArrayList<>();
}
