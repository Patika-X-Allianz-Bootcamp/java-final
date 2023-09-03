package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerRequestDTO extends BaseDTO {
    String name;
    String surname;
    String governmentID;
    List<ExaminationRequestDTO> examinationList = new ArrayList<>();
    List<RoomReservationRequestDTO> roomReservationList = new ArrayList<>();
    List<SeatReservationRequestDTO> seatReservationList = new ArrayList<>();
}
