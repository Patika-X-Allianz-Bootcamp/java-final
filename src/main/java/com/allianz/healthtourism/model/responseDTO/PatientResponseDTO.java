package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import com.allianz.healthtourism.util.security.UserEntity;
import com.allianz.healthtourism.util.security.UserResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class PatientResponseDTO extends PersonResponseDTO {
    private UserResponseDTO user;
    private List<ExaminationRecordResponseDTO> examinationRecords;
    private List<BookingForPatientResponseDTO> bookings;
    private List<AppointmentResponseDTO> appointments;
    private List<PlaneTicketResponseDTO> planeTickets;
}
