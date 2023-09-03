package com.patika.healthtourism.service;

import com.patika.healthtourism.database.entity.RoleEntity;
import com.patika.healthtourism.database.entity.UserEntity;
import com.patika.healthtourism.database.repository.RoleEntityRepository;
import com.patika.healthtourism.database.repository.UserEntityRepository;
import com.patika.healthtourism.mapper.UserMapper;
import com.patika.healthtourism.model.UserDTO;
import com.patika.healthtourism.model.requestDTO.UserRegisterRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserEntityRepository userRepository;
    @Autowired
    RoleEntityRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;
    public UserDTO saveUserByRole(UserRegisterRequestDTO userRegisterRequestDTO) {
        UserEntity user=userMapper.requestDtoToEntity(userRegisterRequestDTO);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        if(roleRepository.findByName(user.getUsername()).isPresent()){
            roles.add(roleRepository.findByName(user.getUsername()).get());
            user.setRoles(roles);
            return userMapper.entityToDto(userRepository.save(user));
        }
        else return null;
    }
    public void saveAdmin(UserRegisterRequestDTO userRegisterRequestDTO) {
        UserEntity user = userMapper.requestDtoToEntity(userRegisterRequestDTO);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ADMIN").get());
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void saveUser(UserRegisterRequestDTO userRegisterRequestDTO) {
        UserEntity user = userMapper.requestDtoToEntity(userRegisterRequestDTO);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER").get());
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void saveDoctor(UserRegisterRequestDTO userRegisterRequestDTO) {
        UserEntity user = userMapper.requestDtoToEntity(userRegisterRequestDTO);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("DOCTOR").get());
        user.setRoles(roles);
        userRepository.save(user);
    }

}
