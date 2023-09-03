package allianz.healthtourism.service;

import allianz.healthtourism.entity.Role;
import allianz.healthtourism.entity.User;
import allianz.healthtourism.repository.RoleRepository;
import allianz.healthtourism.repository.UserRepository;
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


    public void saveUserByRole(User user, String roleName) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(roleName);

        if (role == null) {
            role = new Role();
            role.setName(roleName);
            role.setDescription(roleName + " description");
            role = roleRepository.save(role);
        }

        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }



}
