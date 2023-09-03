package com.allianz.patienttourism.service.rules;


import com.allianz.patienttourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.patienttourism.model.responseDTO.DoctorResponseDTO;
import com.allianz.patienttourism.model.responseDTO.PatientResponseDTO;
import com.allianz.patienttourism.service.DoctorService;
import com.allianz.patienttourism.service.PatientService;
import com.allianz.patienttourism.util.exceptions.DoctorOccupiedException;
import com.allianz.patienttourism.util.exceptions.PatientOccupiedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceRules {

    private final DoctorService doctorService;
    private final PatientService patientService;


    public void checkIfDoctorOccupied(Long doctorId, LocalDateTime appointmentTime){
        DoctorResponseDTO doctorResponseDTO =  doctorService.getByID(doctorId);
        List<AppointmentResponseDTO> appointmentResponseDTOList = doctorResponseDTO.getAppointmentList();

        for (AppointmentResponseDTO appointment:appointmentResponseDTOList) {
            if (appointment.getAppointmentTime().equals(appointmentTime)){
                throw new DoctorOccupiedException("This doctor has already an appointment at the given time");
            }
        }

    }

    public void checkIfPatientOccupied(Long patientId,LocalDateTime appointmentTime){
        PatientResponseDTO patientResponseDTO = patientService.getByID(patientId);
        List<AppointmentResponseDTO> appointmentResponseDTOList = patientResponseDTO.getAppointmentList();

        for (AppointmentResponseDTO appointment:appointmentResponseDTOList) {
            if (appointment.getAppointmentTime().equals(appointmentTime)){
                throw new PatientOccupiedException("You have already an appointment at the given time");
            }
        }
    }

}
