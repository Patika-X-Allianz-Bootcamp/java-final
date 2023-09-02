package patika.fhw.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import patika.fhw.demo.database.entity.RoleEntity;
import patika.fhw.demo.database.entity.UserEntity;
import patika.fhw.demo.database.repository.RoleRepository;
import patika.fhw.demo.database.repository.UserRepository;

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
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("user").get());
        user.setRoles(roles);
        userRepository.save(user);
    }


}
