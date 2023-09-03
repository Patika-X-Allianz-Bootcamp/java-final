package com.healthtourism.healthtourism.service;

import com.healthtourism.healthtourism.Specification.PatientSpecification;
import com.healthtourism.healthtourism.database.entities.DoctorEntity;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.database.entities.RoleEntity;
import com.healthtourism.healthtourism.database.repositories.PatientRepository;
import com.healthtourism.healthtourism.database.repositories.RoleEntityRepository;
import com.healthtourism.healthtourism.mapper.PatientMapper;
import com.healthtourism.healthtourism.model.PatientDTO;
import com.healthtourism.healthtourism.model.RequestDTO.PatientRequestDTO;
import com.healthtourism.healthtourism.util.BaseService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class PatientService extends BaseService<
        PatientEntity,
        PatientDTO,
        PatientRequestDTO,
        PatientMapper,
        PatientRepository,
        PatientSpecification>
{

    @Autowired
    PatientMapper patientMapper;
    @Autowired
     PatientRepository patientRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PatientSpecification patientSpecification;
    @Autowired
    RoleEntityRepository roleRepository;



    @Autowired
    public PatientService(PatientMapper patientMapper, PatientRepository patientRepository,PatientSpecification patientSpecification) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
        this.patientSpecification=patientSpecification;
    }

    @Override
    public PatientMapper getMapper() {
        return patientMapper;
    }

    @Override
    public PatientRepository getRepository() {
        return patientRepository;
    }

    @Override
    protected PatientSpecification getSpecification() {return patientSpecification;}


    public boolean createPatient(String firstName, String lastName, String gender, LocalDate dateOfBirth, String phoneNumber) {
        if (firstName == null || lastName == null || gender == null || dateOfBirth == null || phoneNumber==null) {
            return false;
        } else {
           PatientEntity patientEntity= new PatientEntity();
           patientEntity.setFirstName(firstName);
           patientEntity.setLastName(lastName);
           patientEntity.setGender(gender);
           patientEntity.setDateOfBirth(dateOfBirth);
           patientEntity.setPhoneNumber(phoneNumber);

           patientRepository.save(patientEntity);
            return true;
        }


    }

}


