package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.repository.CityRepository;
import com.allianz.healthtourism.database.repository.DoctorRepository;
import com.allianz.healthtourism.database.specification.CitySpecification;
import com.allianz.healthtourism.database.specification.DoctorSpecification;
import com.allianz.healthtourism.mapper.CityMapper;
import com.allianz.healthtourism.mapper.DoctorMapper;
import com.allianz.healthtourism.model.requestDTO.CityRequestDTO;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorForPatientWithAppointmentResponseDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import com.allianz.healthtourism.util.security.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class DoctorService extends BaseService<DoctorResponseDTO, DoctorRequestDTO, DoctorEntity, DoctorMapper, DoctorRepository, DoctorSpecification> {
    private final DoctorRepository repository;
    private final DoctorSpecification specification;
    private final UserService userService;
    @Override
    protected DoctorMapper getMapper() {
        return DoctorMapper.INSTANCE;
    }
    @Override
    protected DoctorRepository getRepository() {
        return repository;
    }
    @Override
    protected DoctorSpecification getSpecification() {
        return specification;
    }

    public DoctorResponseDTO saveUserByRole(DoctorRequestDTO body) {
        DoctorEntity doctorEntity = getMapper().requestDtoToEntity(body);
        UserEntity userEntity = doctorEntity.getUser();
        UserEntity savedUser = userService.saveUserByDoctorRole(userEntity);
        if(savedUser == null){
            return null;
        }
        DoctorEntity savedDoctor = getRepository().save(doctorEntity);
        return getMapper().entityToResponseDto(savedDoctor);
    }

    public DoctorForPatientWithAppointmentResponseDTO getByUuidForPatient(UUID uuid) {
        DoctorEntity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            return getMapper().entityToPatientResponseDto(entity);
        } else {
            return null;
        }
    }
}
