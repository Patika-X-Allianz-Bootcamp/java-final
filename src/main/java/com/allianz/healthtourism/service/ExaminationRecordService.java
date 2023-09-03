package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.*;
import com.allianz.healthtourism.database.repository.AppointmentRepository;
import com.allianz.healthtourism.database.repository.DoctorRepository;
import com.allianz.healthtourism.database.repository.ExaminationRecordRepository;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.database.specification.ExaminationRecordSpecification;
import com.allianz.healthtourism.database.specification.FlightSpecification;
import com.allianz.healthtourism.mapper.ExaminationRecordMapper;
import com.allianz.healthtourism.mapper.FlightMapper;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourism.model.requestDTO.ExaminationRecordRequestDTO;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.model.requestDTO.PlaneTicketRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationRecordResponseDTO;
import com.allianz.healthtourism.model.responseDTO.FlightResponseDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneTicketResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class ExaminationRecordService extends BaseService<ExaminationRecordResponseDTO, ExaminationRecordRequestDTO, ExaminationRecordEntity, ExaminationRecordMapper, ExaminationRecordRepository, ExaminationRecordSpecification> {
    private final ExaminationRecordRepository repository;
    private final ExaminationRecordSpecification specification;
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    @Override
    protected ExaminationRecordMapper getMapper() {
        return ExaminationRecordMapper.INSTANCE;
    }
    @Override
    protected ExaminationRecordRepository getRepository() {
        return repository;
    }
    @Override
    protected ExaminationRecordSpecification getSpecification() {
        return specification;
    }
    public ExaminationRecordResponseDTO saveWithId(ExaminationRecordRequestDTO requestDTO) {
        AppointmentEntity appointment = appointmentRepository.findById(requestDTO.getAppointmentId()).orElse(null);
        Long doctorId = appointment.getDoctor().getId();
        ExaminationRecordEntity entity = getMapper().requestDtoToEntity(requestDTO);
        entity = getRepository().save(entity);
        DoctorEntity doctor = doctorRepository.findById(doctorId).orElse(null);
        doctor.getExaminationRecords().add(entity);
        doctorRepository.save(doctor);
        return getMapper().entityToResponseDto(entity);
    }
}
