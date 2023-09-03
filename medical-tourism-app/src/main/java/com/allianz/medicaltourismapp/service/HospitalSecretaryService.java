package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.RoleEntity;
import com.allianz.medicaltourismapp.database.entity.roles.HospitalSecretaryEntity;

import com.allianz.medicaltourismapp.database.repository.HospitalSecretaryEntityRepository;
import com.allianz.medicaltourismapp.database.repository.RoleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class HospitalSecretaryService {

    @Autowired
    HospitalSecretaryEntityRepository hospitalSecretaryEntityRepository;
    @Autowired
    RoleEntityRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveUserByRole(HospitalSecretaryEntity hospitalSecretary) {

        hospitalSecretary.setPassword(passwordEncoder.encode(hospitalSecretary.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("hospitalSecretary").get());
        hospitalSecretary.setRoles(roles);
        hospitalSecretaryEntityRepository.save(hospitalSecretary);
    }

}
