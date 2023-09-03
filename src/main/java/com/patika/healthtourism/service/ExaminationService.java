package com.patika.healthtourism.service;

import com.patika.healthtourism.database.entity.AppointmentEntity;
import com.patika.healthtourism.database.entity.ExaminationEntity;
import com.patika.healthtourism.database.repository.ExaminationEntityRepository;
import com.patika.healthtourism.mapper.ExaminationMapper;
import com.patika.healthtourism.model.ExaminationDTO;
import com.patika.healthtourism.model.requestDTO.ExaminationCreateRequestDTO;
import com.patika.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ExaminationService extends BaseService<ExaminationEntity, ExaminationDTO, ExaminationCreateRequestDTO,
        ExaminationMapper, ExaminationEntityRepository> {
    private final ExaminationMapper examinationMapper;
    private final ExaminationEntityRepository examinationEntityRepository;
    private final AppointmentService appointmentService;

    public ExaminationService(ExaminationMapper examinationMapper, ExaminationEntityRepository examinationEntityRepository, AppointmentService appointmentService) {
        this.examinationMapper = examinationMapper;
        this.examinationEntityRepository = examinationEntityRepository;
        this.appointmentService = appointmentService;
    }

    @Override
    protected ExaminationMapper getMapper() {
        return examinationMapper;
    }

    @Override
    protected ExaminationEntityRepository getRepository() {
        return examinationEntityRepository;
    }

    public ExaminationDTO createExamination(UUID appointmentUuid,
                                            ExaminationCreateRequestDTO examinationCreateRequestDTO) {
        ExaminationEntity examination = new ExaminationEntity();
        examination.setExaminationDateTime(LocalDateTime.now());
        AppointmentEntity appointment=appointmentService.getMapper()
                .dtoToEntity(appointmentService.getByUUID(appointmentUuid));
        examination.setAppointment(appointment);
        examination.setDoctor(appointment.getDoctor());
        examination.setPatient(appointment.getPatient());
        examination.setNotes(examinationCreateRequestDTO.getNotes());
        examinationEntityRepository.save(examination);
        return getMapper().entityToDto(examination);
    }
}
