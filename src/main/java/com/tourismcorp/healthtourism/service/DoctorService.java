package com.tourismcorp.healthtourism.service;

import com.tourismcorp.healthtourism.database.entities.DoctorEntity;
import com.tourismcorp.healthtourism.database.entities.RoleEntity;
import com.tourismcorp.healthtourism.database.entities.UserEntity;
import com.tourismcorp.healthtourism.database.repositories.DoctorRepository;
import com.tourismcorp.healthtourism.database.repositories.RoleRepository;
import com.tourismcorp.healthtourism.database.specification.DoctorSpecification;
import com.tourismcorp.healthtourism.mapper.DoctorMapper;
import com.tourismcorp.healthtourism.model.DoctorDTO;
import com.tourismcorp.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.tourismcorp.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService extends BaseService<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification> {

    private final DoctorRepository doctorRepository;

    private final DoctorMapper doctorMapper;

    private final DoctorSpecification doctorSpecification;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper, DoctorSpecification doctorSpecification,
                         RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
        this.doctorSpecification = doctorSpecification;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected DoctorMapper getMapper() {
        return this.doctorMapper;
    }

    @Override
    protected DoctorRepository getRepository() {
        return this.doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return this.doctorSpecification;
    }

    public void saveDoctorByRole(DoctorEntity doctor) {

        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("doctor").get());
        doctor.setRoles(roles);
        doctorRepository.save(doctor);
    }
}
