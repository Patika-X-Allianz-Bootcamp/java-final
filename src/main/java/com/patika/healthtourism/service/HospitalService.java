package com.patika.healthtourism.service;
import com.patika.healthtourism.database.entity.HealthServiceEntity;
import com.patika.healthtourism.database.entity.HospitalEntity;
import com.patika.healthtourism.database.repository.HospitalEntityRepository;
import com.patika.healthtourism.mapper.HealthServiceMapper;
import com.patika.healthtourism.mapper.HospitalMapper;
import com.patika.healthtourism.model.HealthServiceDTO;
import com.patika.healthtourism.model.HospitalDTO;
import com.patika.healthtourism.model.requestDTO.HealthServiceRequestDTO;
import com.patika.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.patika.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class HospitalService extends BaseService<HospitalEntity, HospitalDTO,
        HospitalRequestDTO, HospitalMapper, HospitalEntityRepository> {

    private final HospitalEntityRepository hospitalRepository;

    private final HospitalMapper hospitalMapper;
    private final HealthServiceService healthServiceService;

    public HospitalService(HospitalEntityRepository hospitalRepository, HospitalMapper hospitalMapper, HealthServiceService healthServiceService) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalMapper = hospitalMapper;
        this.healthServiceService = healthServiceService;
    }


    @Override
    protected HospitalMapper getMapper() {
        return hospitalMapper;
    }

    @Override
    protected HospitalEntityRepository getRepository() {
        return hospitalRepository;
    }
    @Transactional
    public boolean addHealthServiceToHospital(UUID hospitalUuid, HealthServiceRequestDTO healthServiceRequestDTO) {
        Optional<HospitalEntity> hospitalOptional = hospitalRepository.findByUuid(hospitalUuid);

        if (hospitalOptional.isPresent()) {
            HospitalEntity hospital = hospitalOptional.get();
            hospital.getHealthServices().add(healthServiceService.getMapper().requestDtoToEntity(healthServiceRequestDTO));
            hospitalRepository.save(hospital);
            return true;
        }
        return false;
    }

}
