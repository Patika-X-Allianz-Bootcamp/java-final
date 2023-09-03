package com.allianz.medicaltourismapp.service;


import com.allianz.medicaltourismapp.database.entity.RoleEntity;
import com.allianz.medicaltourismapp.database.entity.roles.AdminEntity;
import com.allianz.medicaltourismapp.database.repository.AdminEntityRepository;
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
public class AdminService {

    @Autowired
    AdminEntityRepository adminRepository;
    @Autowired
    RoleEntityRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveUserByRole(AdminEntity admin) {

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("admin").get());
        admin.setRoles(roles);
        adminRepository.save(admin);
    }

}
