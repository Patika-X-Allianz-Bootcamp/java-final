package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.Appointment;
import com.allianz.patienttourism.service.rules.AppointmentServiceRules;
import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.patienttourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends BaseService<Appointment, AppointmentResponseDTO, AppointmentRequestDTO> {

    AppointmentServiceRules appointmentServiceRules;

    public AppointmentService(IBaseRepository<Appointment> repository, MapperService mapperService,
                              BaseSpecification<Appointment> specification, AppointmentServiceRules appointmentServiceRules) {
        super(repository, mapperService, specification);
        this.appointmentServiceRules = appointmentServiceRules;

    }

    @Override
    protected Class<Appointment> getEntityClass() {
        return Appointment.class;
    }

    @Override
    protected Class<AppointmentResponseDTO> getResponseDTOClass() {
        return AppointmentResponseDTO.class;
    }

    @Override
    public AppointmentResponseDTO save(AppointmentRequestDTO requestDTO) {
        appointmentServiceRules.checkIfDoctorOccupied(requestDTO.getDoctorId(),requestDTO.getAppointmentTime());
        appointmentServiceRules.checkIfPatientOccupied(requestDTO.getPatientId(),requestDTO.getAppointmentTime());
        return super.save(requestDTO);
    }
}
