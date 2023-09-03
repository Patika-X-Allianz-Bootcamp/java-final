package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.PatientEntity;
import com.example.healthtourismapp.database.entities.RoleEntity;
import com.example.healthtourismapp.database.repositories.PatientRepository;
import com.example.healthtourismapp.database.repositories.RoleEntityRepository;
import com.example.healthtourismapp.database.specification.PatientSpecification;
import com.example.healthtourismapp.database.specification.ReportSpecification;
import com.example.healthtourismapp.mapper.PatientMapper;
import com.example.healthtourismapp.model.PatientDTO;
import com.example.healthtourismapp.model.requestDTO.PatientRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PatientService extends BaseService<
        PatientEntity,
        PatientDTO,
        PatientRequestDTO,
        PatientMapper,
        PatientRepository, PatientSpecification> {


    private final PatientMapper patientMapper;

    private final PatientRepository patientRepository;

    private final PatientSpecification patientSpecification;

    private final RoleEntityRepository roleEntityRepository;

    private final PasswordEncoder passwordEncoder;


    public PatientService(PatientMapper patientMapper, PatientRepository patientRepository, ReportSpecification reportSpecification, PatientSpecification patientSpecification, RoleEntityRepository roleEntityRepository, PasswordEncoder passwordEncoder) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
        this.patientSpecification = patientSpecification;
        this.roleEntityRepository = roleEntityRepository;
        this.passwordEncoder = passwordEncoder;
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
    protected PatientSpecification getSpecification() {
        return patientSpecification;
    }

    public void saveUserByRole(PatientEntity patient) {

        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleEntityRepository.findByName("user").get());
        patient.setRoles(roles);
        patientRepository.save(patient);
    }
}
