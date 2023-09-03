package com.healthtourism.healthtourism.service;

import com.healthtourism.healthtourism.Specification.UserSpecification;
import com.healthtourism.healthtourism.database.entities.RoleEntity;
import com.healthtourism.healthtourism.database.entities.UserEntity;
import com.healthtourism.healthtourism.database.repositories.RoleEntityRepository;
import com.healthtourism.healthtourism.database.repositories.UserRepository;
import com.healthtourism.healthtourism.mapper.UserMapper;
import com.healthtourism.healthtourism.model.RequestDTO.UserRequestDTO;
import com.healthtourism.healthtourism.model.UserDTO;
import com.healthtourism.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class UserService  extends BaseService<
        UserEntity,
        UserDTO,
        UserRequestDTO,
        UserMapper,
        UserRepository,
        UserSpecification> {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleEntityRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserSpecification userSpecification;

    public void saveUserByRole(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        for (RoleEntity role : user.getRoles()) {
            RoleEntity tmpRole = findRoleByName(role.getName());
            if (tmpRole != null) {
                roles.add(tmpRole);
            }
        }
        user.setRoles(roles);
        userRepository.save(user);
    }

    // Add save methods for user, admin, doctor

    public void saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity userRole = findRoleByName("user");
        if (userRole != null) {
            roles.add(userRole);
            user.setRoles(roles);
            userRepository.save(user);
        } else {
            // Handle the case when the "user" role is not found
            throw new RuntimeException("Kullanıcı rolü bulunamadı: 'user'");
        }
    }

    public void savePatient(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity patientRole = findRoleByName("patient");
        if (patientRole != null) {
            roles.add(patientRole);
            user.setRoles(roles);
            userRepository.save(user);
        } else {
            // Handle the case when the "patient" role is not found
            throw new RuntimeException("Kullanıcı rolü bulunamadı: 'patient'");
        }
    }

    // Helper method to safely find a role by name
    private RoleEntity findRoleByName(String roleName) {
        Optional<RoleEntity> roleOptional = roleRepository.findByName(roleName);
        return roleOptional.orElse(null);
    }


    @Override
    public UserMapper getMapper() {
        return userMapper;
    }

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    protected UserSpecification getSpecification() {
        return userSpecification;
    }


}
