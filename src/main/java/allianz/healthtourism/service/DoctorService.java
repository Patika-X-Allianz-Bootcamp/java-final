package allianz.healthtourism.service;

import allianz.healthtourism.base.BaseService;
import allianz.healthtourism.dto.Request.DoctorRequest;
import allianz.healthtourism.dto.Response.DoctorDTO;
import allianz.healthtourism.dto.Response.PatientDTO;
import allianz.healthtourism.entity.Appointment;
import allianz.healthtourism.entity.Doctor;
import allianz.healthtourism.entity.Patient;
import allianz.healthtourism.exception.BusinessException;
import allianz.healthtourism.mapper.ModelMapperManager;
import allianz.healthtourism.repository.AppointmentRepository;
import allianz.healthtourism.repository.DoctorRepository;
import allianz.healthtourism.repository.PatientRepository;
import allianz.healthtourism.specification.DoctorSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorService extends BaseService<Doctor, DoctorDTO, DoctorRequest, DoctorRepository, DoctorSpecification> {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorSpecification doctorSpecification;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    ModelMapperManager modelMapperManager;


    public DoctorService(ModelMapperManager modelMapperManager) {
        super(modelMapperManager);
    }

    @Override
    protected Class<Doctor> getEntity() {
        return Doctor.class;
    }

    @Override
    protected DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return doctorSpecification;
    }

    @Override
    protected Class<DoctorDTO> getDto() {
        return DoctorDTO.class;
    }

    @Override
    protected Class<DoctorRequest> getRequestDto() {
        return DoctorRequest.class;
    }

    public void assignPatientToDoctor(UUID doctorUuid, UUID patientUuid ){

        Doctor doctor = doctorRepository.findByUuid(doctorUuid).orElseThrow(() -> new BusinessException("Doctor not found with id: " + doctorUuid));
        Patient patient = patientRepository.findByUuid(patientUuid).orElseThrow(() -> new BusinessException("Patient not found with id: " + patientUuid));

        if (doctor.getPatients().contains(patient)) {
            throw new BusinessException("An appointment already exists with this doctor and patient.");
        }

        doctor.getPatients().add(patient);

        doctorRepository.save(doctor);
    }

    public List<PatientDTO> listAssignedPatients(UUID doctorUuid) {
        Doctor doctor = doctorRepository.findByUuid(doctorUuid)
                .orElseThrow(() -> new BusinessException("Doctor not found with id: " + doctorUuid));

        List<Patient> patients = doctor.getPatients();

        List<PatientDTO> patientDTOs = patients.stream()
                .map(patient -> modelMapperManager.forResponse().map(patient, PatientDTO.class))
                .collect(Collectors.toList());

        return patientDTOs;
    }

}



