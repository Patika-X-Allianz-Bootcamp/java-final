package patika.fhw.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import patika.fhw.demo.database.entity.Patient;
import patika.fhw.demo.database.entity.RoleEntity;
import patika.fhw.demo.database.repository.PatientRepository;
import patika.fhw.demo.database.repository.RoleRepository;
import patika.fhw.demo.database.specification.PatientSpecification;
import patika.fhw.demo.mapper.PatientMapper;
import patika.fhw.demo.model.dto.PatientDTO;
import patika.fhw.demo.model.requestDTO.PatientRequestDTO;
import patika.fhw.demo.util.BaseService;

@Service
public class PatientService extends BaseService<Patient, PatientDTO, PatientRequestDTO, PatientMapper, PatientRepository, PatientSpecification> {
    @Autowired 
    PasswordEncoder passwordEncoder;
    private final PatientMapper mapper;
    private final PatientRepository repository;
    private final PatientSpecification specification; 
    private final RoleRepository roleRepository;
    

    public PatientService(PatientMapper mapper, PatientRepository repository, PatientSpecification specification, RoleRepository roleRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.specification = specification;
        this.roleRepository = roleRepository;
    }

    @Override
    protected PatientMapper getMapper() {
        return mapper;
    }

    @Override
    protected PatientRepository getRepository() {
        return repository;
    }

    @Override
    protected PatientSpecification getSpecification() {
        return specification;
    } 

    public void savePatientByRole(Patient patient) {
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("patient").get());
        patient.setRoles(roles);
        repository.save(patient);
    }
}
