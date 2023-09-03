package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.RoleEntity;
import com.burakcanciftci.healthtourism.database.entity.UserEntity;
import com.burakcanciftci.healthtourism.database.repository.RoleEntityRepository;
import com.burakcanciftci.healthtourism.database.repository.UserEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.UserSpecification;
import com.burakcanciftci.healthtourism.model.UserRegistrationDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.UserRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.UserResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import com.burakcanciftci.healthtourism.util.BaseService;
import com.burakcanciftci.healthtourism.util.UserMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserService {
    private final UserEntityRepository userRepository;
    private final RoleEntityRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUserByRole(UserRegistrationDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();

        Optional<RoleEntity> roleEntityOptional;
        for(String roleName : user.getRoles()){
            roleEntityOptional = roleRepository.findByName(roleName);

            if(roleEntityOptional.isPresent()){
                roles.add(roleEntityOptional.get());
            }
        }

        UserEntity userEntity = Mappers.getMapper(UserMapper.class).dtoToEntity(user);

        userEntity.setRoles(roles);
        userRepository.save(userEntity);
    }
}