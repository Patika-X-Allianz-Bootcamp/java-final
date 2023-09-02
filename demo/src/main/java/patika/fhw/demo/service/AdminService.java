package patika.fhw.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import patika.fhw.demo.database.entity.AdminEntity;
import patika.fhw.demo.database.entity.RoleEntity;
import patika.fhw.demo.database.repository.AdminRepository;
import patika.fhw.demo.database.repository.RoleRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public void saveAdminByRole(AdminEntity admin) {

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("admin").get());
        admin.setRoles(roles);
        adminRepository.save(admin);
    }


}
