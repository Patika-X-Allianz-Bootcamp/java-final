package com.tourismcorp.healthtourism.service;

import com.tourismcorp.healthtourism.database.entities.RoleEntity;
import com.tourismcorp.healthtourism.database.entities.UserEntity;
import com.tourismcorp.healthtourism.database.repositories.RoleRepository;
import com.tourismcorp.healthtourism.database.repositories.UserRepository;
import com.tourismcorp.healthtourism.database.specification.UserSpecification;
import com.tourismcorp.healthtourism.mapper.UserMapper;
import com.tourismcorp.healthtourism.model.UserDTO;
import com.tourismcorp.healthtourism.model.requestDTO.UserRequestDTO;
import com.tourismcorp.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService extends BaseService<
        UserEntity,
        UserDTO,
        UserRequestDTO,
        UserMapper,
        UserRepository,
        UserSpecification> {


    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final UserSpecification userSpecification;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, UserSpecification userSpecification,
                       RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userSpecification = userSpecification;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected UserMapper getMapper() {
        return this.userMapper;
    }

    @Override
    protected UserRepository getRepository() {
        return this.userRepository;
    }

    @Override
    protected UserSpecification getSpecification() {
        return this.userSpecification;
    }

    public void saveUserByRole(UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("user").get());
        user.setRoles(roles);
        userRepository.save(user);
    }
}
