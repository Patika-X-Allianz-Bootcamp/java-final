package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.HealthServiceEntity;
import com.example.healthtourismapp.database.entities.HospitalEntity;
import com.example.healthtourismapp.database.repositories.HospitalRepository;
import com.example.healthtourismapp.database.repositories.HotelRepository;
import com.example.healthtourismapp.database.specification.HospitalSpecification;
import com.example.healthtourismapp.mapper.HospitalMapper;
import com.example.healthtourismapp.model.HospitalDTO;
import com.example.healthtourismapp.model.requestDTO.HospitalRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HospitalService extends BaseService<
        HospitalEntity,
        HospitalDTO,
        HospitalRequestDTO,
        HospitalMapper,
        HospitalRepository, HospitalSpecification> {

    private final HospitalMapper hospitalMapper;
    private final HospitalRepository hospitalRepository;
    private final HotelRepository hotelRepository;
    private final HospitalSpecification hospitalSpecification;

    public HospitalService(HospitalMapper hospitalMapper, HospitalRepository hospitalRepository, HotelRepository hotelRepository, HospitalSpecification hospitalSpecification) {
        this.hospitalMapper = hospitalMapper;
        this.hospitalRepository = hospitalRepository;
        this.hotelRepository = hotelRepository;
        this.hospitalSpecification = hospitalSpecification;
    }

    @Override
    public HospitalMapper getMapper() {
        return hospitalMapper;
    }

    @Override
    public HospitalRepository getRepository() {
        return hospitalRepository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return hospitalSpecification;
    }

    public Optional<HealthServiceEntity> selectHealthService(UUID hospitalUuid, UUID healthServiceUUid) {
        Optional<HospitalEntity> hospitalOptional = hospitalRepository.findByUuid(hospitalUuid);
        if (hospitalOptional.isPresent()) {
            HospitalEntity hospital = hospitalOptional.get();
            for (HealthServiceEntity healthService : hospital.getHealthServiceList()) {
                if (hospital.getUuid().equals(healthServiceUUid)) {
                    return Optional.of(healthService);
                }
            }
        }
        return Optional.empty();
    }

}
