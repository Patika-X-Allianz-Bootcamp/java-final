package com.allianz.healthtourism.util.security;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.service.DoctorService;
import com.allianz.healthtourism.service.PatientService;
import com.allianz.healthtourism.util.BaseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService<UserResponseDTO, UserRequestDTO, UserEntity, UserMapper, UserEntityRepository, UserSpecification> {

    private final UserEntityRepository userRepository;
    private final RoleEntityRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserSpecification userSpecification;

    @Override
    protected UserMapper getMapper() {
        return UserMapper.INSTANCE;
    }

    @Override
    protected UserEntityRepository getRepository() {
        return userRepository;
    }

    @Override
    protected UserSpecification getSpecification() {
        return userSpecification;
    }

    @Transactional
    public boolean saveUserByRole(UserRequestDTO userRequestDTO) {
        if (!isEmailExist(userRequestDTO.getEmail())) {
            UserEntity user = getMapper().requestDtoToEntity(userRequestDTO);
            user.setEnable(false);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<RoleEntity> roles = new HashSet<>();
            RoleEntity roleEntity = roleRepository.findByName("user").orElse(null);
            if (roleEntity == null) {
                roleEntity = new RoleEntity();
                roleEntity.setName("user");
                roleEntity = roleRepository.save(roleEntity);
            }
//            user.setProfile(new ProfileEntity());
            roles.add(roleEntity);
            user.setRoles(roles);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean saveAdmin(UserRequestDTO userRequestDTO) {
        if (!isEmailExist(userRequestDTO.getEmail())) {
            UserEntity user = getMapper().requestDtoToEntity(userRequestDTO);
            user.setEnable(false);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<RoleEntity> roles = new HashSet<>();
            RoleEntity roleEntity = roleRepository.findByName("admin").orElse(null);
            if (roleEntity == null) {
                roleEntity = new RoleEntity();
                roleEntity.setName("admin");
                roleEntity = roleRepository.save(roleEntity);
            }
            roles.add(roleEntity);
            user.setRoles(roles);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean isEmailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


    public UserEntity saveUserByDoctorRole(UserEntity user) {
        if (!isEmailExist(user.getEmail())) {
            user.setEnable(false);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<RoleEntity> roles = new HashSet<>();
            RoleEntity roleEntity = roleRepository.findByName("doctor").orElse(null);
            if (roleEntity == null) {
                roleEntity = new RoleEntity();
                roleEntity.setName("doctor");
                roleEntity = roleRepository.save(roleEntity);
            }
            roles.add(roleEntity);
            user.setRoles(roles);
            UserEntity userEntity = userRepository.save(user);
            return userEntity;
        }
        return null;
    }

    public UserEntity saveUserByPatientRole(UserEntity user) {
        if (!isEmailExist(user.getEmail())) {
            user.setEnable(false);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<RoleEntity> roles = new HashSet<>();
            RoleEntity roleEntity = roleRepository.findByName("patient").orElse(null);
            if (roleEntity == null) {
                roleEntity = new RoleEntity();
                roleEntity.setName("patient");
                roleEntity = roleRepository.save(roleEntity);
            }
            roles.add(roleEntity);
            user.setRoles(roles);
            UserEntity userEntity = userRepository.save(user);
            return userEntity;
        }
        return null;
    }
}
