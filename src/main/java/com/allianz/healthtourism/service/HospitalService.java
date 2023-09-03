package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.HealthCareServiceEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.repository.HospitalRepository;
import com.allianz.healthtourism.database.specification.HospitalSpecification;
import com.allianz.healthtourism.mapper.HospitalMapper;
import com.allianz.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HospitalForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HospitalResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class HospitalService extends BaseService<HospitalResponseDTO, HospitalRequestDTO, HospitalEntity, HospitalMapper, HospitalRepository, HospitalSpecification> {
    private final HospitalRepository repository;
    private final HospitalSpecification specification;
    private final HealthCareServiceService healthCareServiceService;

    @Override
    protected HospitalMapper getMapper() {
        return HospitalMapper.INSTANCE;
    }

    @Override
    protected HospitalRepository getRepository() {
        return repository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return specification;
    }

    public HospitalResponseDTO addHealthCareServiceToHospital(UUID healthCareServiceUuid, UUID hospitalUuid) {
        HospitalEntity hospital = getRepository().findByUuid(hospitalUuid).orElse(null);
        HealthCareServiceEntity healthCareService = healthCareServiceService.getEntityByUuid(healthCareServiceUuid);
        if (hospital.getHealthCareServices() == null) {
            hospital.setHealthCareServices(new ArrayList<>());
        }
        hospital.getHealthCareServices().add(healthCareService);
        if (healthCareService.getHospitals() == null) {
            healthCareService.setHospitals(new ArrayList<>());
        }
        healthCareService.getHospitals().add(hospital);
        healthCareServiceService.getRepository().save(healthCareService);
        hospital = repository.save(hospital);
        return getMapper().entityToResponseDto(hospital);
    }

    public HospitalForPatientResponseDTO getByUuidForPatient(UUID uuid) {
        HospitalEntity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            return getMapper().entityToPatientResponseDto(entity);
        } else {
            return null;
        }
    }
}
