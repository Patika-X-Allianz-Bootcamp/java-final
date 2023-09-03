package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.repository.HotelRepository;
import com.allianz.healthtourism.database.repository.PatientRepository;
import com.allianz.healthtourism.database.specification.HotelSpecification;
import com.allianz.healthtourism.database.specification.PatientSpecification;
import com.allianz.healthtourism.mapper.HotelMapper;
import com.allianz.healthtourism.mapper.PatientMapper;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HotelResponseDTO;
import com.allianz.healthtourism.model.responseDTO.PatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import com.allianz.healthtourism.util.security.UserEntity;
import com.allianz.healthtourism.util.security.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PatientService extends BaseService<PatientResponseDTO, PatientRequestDTO, PatientEntity, PatientMapper, PatientRepository, PatientSpecification> {
    private final PatientRepository repository;
    private final PatientSpecification specification;
    private final UserService userService;

    @Override
    protected PatientMapper getMapper() {
        return PatientMapper.INSTANCE;
    }

    @Override
    protected PatientRepository getRepository() {
        return repository;
    }

    @Override
    protected PatientSpecification getSpecification() {
        return specification;
    }

    public PatientResponseDTO saveUserByRole(PatientRequestDTO body) {
        PatientEntity patientEntity = getMapper().requestDtoToEntity(body);
        UserEntity userEntity = patientEntity.getUser();
        UserEntity savedUser = userService.saveUserByPatientRole(userEntity);
        if(savedUser == null){
            return null;
        }
        PatientEntity savedPatient = getRepository().save(patientEntity);
        return getMapper().entityToResponseDto(savedPatient);
    }

    public PatientEntity findById(Long id){
        return getRepository().findById(id).orElse(null);
    }
}
