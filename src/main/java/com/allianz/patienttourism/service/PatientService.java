package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.Patient;
import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.PatientRequestDTO;
import com.allianz.patienttourism.model.responseDTO.PatientResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<Patient, PatientResponseDTO, PatientRequestDTO> {


    public PatientService(IBaseRepository<Patient> repository, MapperService mapperService, BaseSpecification<Patient> specification) {
        super(repository, mapperService, specification);
    }

    @Override
    protected Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    protected Class<PatientResponseDTO> getResponseDTOClass() {
        return PatientResponseDTO.class;
    }
}
