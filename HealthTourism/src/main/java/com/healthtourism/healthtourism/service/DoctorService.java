package com.healthtourism.healthtourism.service;
import com.healthtourism.healthtourism.Specification.DoctorSpecification;
import com.healthtourism.healthtourism.database.entities.DoctorEntity;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.database.entities.SpecializationEnum;
import com.healthtourism.healthtourism.database.repositories.DoctorRepository;
import com.healthtourism.healthtourism.database.repositories.PatientRepository;
import com.healthtourism.healthtourism.mapper.DoctorMapper;
import com.healthtourism.healthtourism.model.DoctorDTO;
import com.healthtourism.healthtourism.model.PatientDTO;
import com.healthtourism.healthtourism.model.RequestDTO.DoctorRequestDTO;
import com.healthtourism.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorService extends BaseService<DoctorEntity, DoctorDTO, DoctorRequestDTO, DoctorMapper, DoctorRepository, DoctorSpecification> {
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorSpecification doctorSpecification;

    @Override
    public DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    public DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {return doctorSpecification;}

    public boolean createDoctor(String firstName, String lastName, String specialization) {
        if (firstName == null || lastName == null || specialization == null) {
            return false;

        } else {

            // Geçerli uzmanlık alanı girilmiş mi kontrol et
            if (!isValidSpecialization(specialization)) {
                return false; // Geçerli olmayan bir uzmanlık alanı girilmişse işlemi reddet
            }
            DoctorEntity doctorEntity = new DoctorEntity();
            doctorEntity.setUuid(UUID.randomUUID());
            doctorEntity.setFirstName(firstName);
            doctorEntity.setLastName(lastName);
            doctorEntity.setSpecialization(specialization);

            doctorRepository.save(doctorEntity);
            return true;
        }
    }

   public boolean isValidSpecialization(String specialization) {
        String lowerCaseSpecialization = specialization.toLowerCase(); // Uzmanlık alanını küçük harfe dönüştür

        for (SpecializationEnum enumValue : SpecializationEnum.values()) {
            if (enumValue.getValue().toLowerCase().equals(lowerCaseSpecialization)) {
                return true; // Geçerli bir uzmanlık alanı bulundu
            }
        }
        return false; // Geçerli bir uzmanlık alanı bulunamadı

    }

    public List<PatientDTO> listAssignedPatients(UUID doctorUuid) {
        DoctorEntity doctor = doctorRepository.findByUuid(doctorUuid)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorUuid));

        List<PatientEntity> patients = doctor.getPatients();

        List<PatientDTO> patientDTOs = patients.stream()
                .map(patientEntity -> {
                    PatientDTO patientDTO = new PatientDTO();
                    patientDTO.setId(patientEntity.getId()); // Set other properties as needed
                    // You can manually set other properties here if needed
                    return patientDTO;
                })
                .collect(Collectors.toList());

        return patientDTOs;
    }


}
