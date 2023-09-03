package allianz.healthtourism.service;

import allianz.healthtourism.base.BaseService;
import allianz.healthtourism.dto.Request.ExaminationRequest;
import allianz.healthtourism.dto.Response.ExaminationDTO;
import allianz.healthtourism.entity.Appointment;
import allianz.healthtourism.entity.Examination;
import allianz.healthtourism.exception.BusinessException;
import allianz.healthtourism.mapper.ModelMapperManager;
import allianz.healthtourism.repository.AppointmentRepository;
import allianz.healthtourism.repository.ExaminationRepository;
import allianz.healthtourism.specification.ExaminationSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ExaminationService extends BaseService<Examination, ExaminationDTO, ExaminationRequest, ExaminationRepository, ExaminationSpecification> {

    @Autowired
    ExaminationRepository examinationRepository;

    @Autowired
    ExaminationSpecification examinationSpecification;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    ModelMapperManager modelMapperManager;

    public ExaminationService(ModelMapperManager modelMapperManager) {
        super(modelMapperManager);
    }

    @Override
    protected Class<Examination> getEntity() {
        return Examination.class;
    }

    @Override
    protected ExaminationRepository getRepository() {
        return examinationRepository;
    }

    @Override
    protected ExaminationSpecification getSpecification() {
        return examinationSpecification;
    }

    @Override
    protected Class<ExaminationDTO> getDto() {
        return ExaminationDTO.class;
    }

    @Override
    protected Class<ExaminationRequest> getRequestDto() {
        return ExaminationRequest.class;
    }



    public ExaminationDTO createExamination(UUID appointmentUuid, ExaminationRequest examinationRequest) {

        Appointment appointment = appointmentRepository.findByUuid(appointmentUuid)
                .orElseThrow(() -> new BusinessException("Appointment not found with id: " + appointmentUuid));

        Examination examination = modelMapperManager.forRequest().map(examinationRequest, Examination.class);
        examination.setAppointment(appointment);

        Examination savedExamination = examinationRepository.save(examination);

        ExaminationDTO examinationDTO = modelMapperManager.forRequest().map(savedExamination, ExaminationDTO.class);

        return examinationDTO;
    }



    public List<ExaminationDTO> listAllExaminations() {
        List<Examination> examinations = examinationRepository.findAll();

        return (List<ExaminationDTO>) examinations.stream().
                map(category -> this.modelMapperManager.forResponse()
                        .map(category, ExaminationDTO.class)).collect(Collectors.toList());
    }


}
