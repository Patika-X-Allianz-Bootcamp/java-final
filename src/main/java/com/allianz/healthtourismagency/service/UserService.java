package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.RoleEntity;
import com.allianz.healthtourismagency.database.entity.UserEntity;
import com.allianz.healthtourismagency.database.repository.RoleRepository;
import com.allianz.healthtourismagency.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public void saveUserByRole(UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        /*
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("user").get());
        user.setRoles(roles);*/
        userRepository.save(user);
    }


}
