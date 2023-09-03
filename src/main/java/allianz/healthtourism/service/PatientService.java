package allianz.healthtourism.service;

import allianz.healthtourism.base.BaseService;
import allianz.healthtourism.dto.Request.HotelRequest;
import allianz.healthtourism.dto.Request.PatientRequest;
import allianz.healthtourism.dto.Response.HotelDTO;
import allianz.healthtourism.dto.Response.PatientDTO;
import allianz.healthtourism.entity.Hotel;
import allianz.healthtourism.entity.Patient;
import allianz.healthtourism.mapper.ModelMapperManager;
import allianz.healthtourism.repository.HotelRepository;
import allianz.healthtourism.repository.PatientRepository;
import allianz.healthtourism.specification.HotelSpecification;
import allianz.healthtourism.specification.PatientSpecification;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<Patient, PatientDTO, PatientRequest, PatientRepository, PatientSpecification> {


    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientSpecification patientSpecification;


    public PatientService(ModelMapperManager modelMapperManager) {
        super(modelMapperManager);
    }

    @Override
    protected Class<Patient> getEntity() {
        return Patient.class;
    }

    @Override
    protected PatientRepository getRepository() {
        return patientRepository;
    }

    @Override
    protected PatientSpecification getSpecification() {
        return patientSpecification;
    }

    @Override
    protected Class<PatientDTO> getDto() {
        return PatientDTO.class;
    }

    @Override
    protected Class<PatientRequest> getRequestDto() {
        return PatientRequest.class;
    }

}
