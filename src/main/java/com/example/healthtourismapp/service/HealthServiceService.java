package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.DoctorEntity;
import com.example.healthtourismapp.database.entities.HealthServiceEntity;
import com.example.healthtourismapp.database.repositories.HealthServiceRepository;
import com.example.healthtourismapp.database.specification.HealthServiceSpecification;
import com.example.healthtourismapp.mapper.HealthServiceMapper;
import com.example.healthtourismapp.model.HealthServiceDTO;
import com.example.healthtourismapp.model.requestDTO.HealthServiceRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HealthServiceService extends BaseService<
        HealthServiceEntity,
        HealthServiceDTO,
        HealthServiceRequestDTO,
        HealthServiceMapper,
        HealthServiceRepository, HealthServiceSpecification> {

    private final HealthServiceMapper healthServiceMapper;
    private final HealthServiceRepository healthServiceRepository;
    private final HealthServiceSpecification healthServiceSpecification;

    public HealthServiceService(HealthServiceMapper healthServiceMapper, HealthServiceRepository healthServiceRepository, HealthServiceSpecification healthServiceSpecification) {
        this.healthServiceMapper = healthServiceMapper;
        this.healthServiceRepository = healthServiceRepository;
        this.healthServiceSpecification = healthServiceSpecification;
    }

    @Override
    public HealthServiceMapper getMapper() {
        return healthServiceMapper;
    }

    @Override
    public HealthServiceRepository getRepository() {
        return healthServiceRepository;
    }

    @Override
    protected HealthServiceSpecification getSpecification() {
        return healthServiceSpecification;
    }

    public Optional<DoctorEntity> selectDoctor(UUID healthServiceUuid, UUID doctorUuid) {
        Optional<HealthServiceEntity> healthServiceOptional = healthServiceRepository.findByUuid(healthServiceUuid);
        if (healthServiceOptional.isPresent()) {
            HealthServiceEntity healthService = healthServiceOptional.get();
            for (DoctorEntity doctor : healthService.getDoctorList()) {
                if (healthService.getUuid().equals(doctorUuid)) {
                    return Optional.of(doctor);
                }
            }
        }
        return Optional.empty();
    }
}
