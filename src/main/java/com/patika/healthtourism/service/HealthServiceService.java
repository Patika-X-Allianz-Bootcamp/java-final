package com.patika.healthtourism.service;

import com.patika.healthtourism.database.entity.DoctorEntity;
import com.patika.healthtourism.database.entity.HealthServiceEntity;
import com.patika.healthtourism.database.repository.HealthServiceEntityRepository;
import com.patika.healthtourism.mapper.HealthServiceMapper;
import com.patika.healthtourism.model.HealthServiceDTO;
import com.patika.healthtourism.model.requestDTO.DoctorCreateRequestDTO;
import com.patika.healthtourism.model.requestDTO.HealthServiceRequestDTO;
import com.patika.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class HealthServiceService extends BaseService<HealthServiceEntity, HealthServiceDTO, HealthServiceRequestDTO,
        HealthServiceMapper, HealthServiceEntityRepository> {
    private final HealthServiceMapper healthServiceMapper;
    private final HealthServiceEntityRepository healthServiceEntityRepository;
    private final DoctorService doctorService;

    public HealthServiceService(HealthServiceMapper healthServiceMapper, HealthServiceEntityRepository healthServiceEntityRepository, DoctorService doctorService) {
        this.healthServiceMapper = healthServiceMapper;
        this.healthServiceEntityRepository = healthServiceEntityRepository;
        this.doctorService = doctorService;
    }

    @Override
    protected HealthServiceMapper getMapper() {
        return healthServiceMapper;
    }

    @Override
    protected HealthServiceEntityRepository getRepository() {
        return healthServiceEntityRepository;
    }
    @Transactional
    public boolean addDoctorToHealthService(UUID healthServiceUuid, DoctorCreateRequestDTO doctorRequestDTO) {
        Optional<HealthServiceEntity> healthServiceOptional = healthServiceEntityRepository.findByUuid(healthServiceUuid);

        if (healthServiceOptional.isPresent()) {
            HealthServiceEntity healthService = healthServiceOptional.get();
            healthService.getServiceDoctors().add(doctorService.getMapper().requestDtoToEntity(doctorRequestDTO));
            healthServiceEntityRepository.save(healthService);
            return true;
        }
        return false;
    }
}
