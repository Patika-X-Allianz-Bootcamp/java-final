package patika.fhw.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import patika.fhw.demo.database.entity.Doctor;
import patika.fhw.demo.database.entity.RoleEntity;
import patika.fhw.demo.database.repository.DoctorRepository;
import patika.fhw.demo.database.repository.RoleRepository;
import patika.fhw.demo.database.specification.DoctorSpecification;
import patika.fhw.demo.mapper.DoctorMapper;
import patika.fhw.demo.model.dto.DoctorDTO;
import patika.fhw.demo.model.requestDTO.DoctorRequestDTO;
import patika.fhw.demo.util.BaseService;

@Service
public class DoctorService extends BaseService<Doctor, DoctorDTO, DoctorRequestDTO, DoctorMapper, DoctorRepository, DoctorSpecification> {
    @Autowired
    PasswordEncoder passwordEncoder;
    private final DoctorMapper mapper;
    private final DoctorRepository doctorRepository;
    private final DoctorSpecification specification;
    private final RoleRepository roleRepository;

    public DoctorService(DoctorMapper mapper, DoctorRepository doctorRepository, DoctorSpecification specification, RoleRepository roleRepository) {
        this.mapper = mapper;
        this.doctorRepository = doctorRepository;
        this.specification = specification;
        this.roleRepository = roleRepository;
    } 


    @Override
    protected DoctorMapper getMapper() {
        return mapper;
    }

    @Override
    protected DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return specification;
    }
    public void saveDoctorByRole(Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("doctor").get());
        doctor.setRoles(roles);
        doctorRepository.save(doctor);
    }
}
