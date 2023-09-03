package com.allianz.patienttourism.util.security;

import com.allianz.patienttourism.util.mapper.MapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserEntityRepository userRepository;

    private final RoleEntityRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final MapperService mapperService;



    public void saveUserByRole(UserRequestDTO userRequestDTO) {
        UserEntity user = mapperService.requestMapper().map(userRequestDTO,UserEntity.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }


}
