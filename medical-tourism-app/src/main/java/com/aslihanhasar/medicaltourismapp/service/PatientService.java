package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.PatientSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.PatientSaveResponse;
import com.aslihanhasar.medicaltourismapp.entity.Appointment;
import com.aslihanhasar.medicaltourismapp.entity.City;
import com.aslihanhasar.medicaltourismapp.entity.Patient;
import com.aslihanhasar.medicaltourismapp.exception.*;
import com.aslihanhasar.medicaltourismapp.repository.PatientRepository;
import com.aslihanhasar.medicaltourismapp.utils.UniqueNumberGeneratorUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * Service class responsible for managing patients, including patient creation and retrieval.
 */
@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final CityService cityService;

    /**
     * Saves a new patient based on the provided request and returns a response.
     *
     * @param request The request containing patient details.
     * @return A response containing information about the saved patient.
     */
    @Transactional
    public PatientSaveResponse save(PatientSaveRequest request) {
        validatePatientSaveRequest(request);
        Patient savedPatient = buildAndSavePatient(request);
        return convertPatientToResponse(savedPatient);
    }

    /**
     * Retrieves a patient by their unique patient number.
     *
     * @param patientNumber The unique patient number of the patient to retrieve.
     * @return The patient matching the provided patient number.
     * @throws PatientNotFoundException if no patient is found with the given patient number.
     */
    public Patient getByPatientNumber(String patientNumber) {
        return patientRepository.findByPatientNumber(patientNumber)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found."));
    }

    protected PatientSaveResponse convertPatientToResponse(Patient patient) {
        String patientNumber = generateUniquePatientNumber();
        return PatientSaveResponse.builder()
                .patient(patient.getFirstName() + " " + patient.getLastName())
                .patientNumber(patientNumber)
                .city(patient.getCity().getName() + " - " + patient.getCity().getCountry().getName())
                .build();
    }

    protected void addAppointmentToPatient(Patient patient, Appointment appointment) {
        List<Appointment> appointments = patient.getAppointments();
        appointments.add(appointment);
        patient.setAppointments(appointments);
        patientRepository.save(patient);
    }

    private String generateUniquePatientNumber() {
        return UniqueNumberGeneratorUtils.generateUniqueNumber();
    }

    private Patient buildAndSavePatient(PatientSaveRequest request) {
        City cityById = cityService.getCityById(request.getCityId());
        Patient patient = Patient.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .city(cityById)
                .build();
        return patientRepository.save(patient);
    }

    private void validatePatientSaveRequest(PatientSaveRequest request) {
        boolean anyFieldBlank = Stream.of(request.getFirstName(),
                        request.getLastName(),
                        request.getCityId())
                .anyMatch(value -> value == null || value.toString().trim().isEmpty());
        if (anyFieldBlank) {
            throw new PatientValidationException("Required fields cannot be left blank");
        }
    }

}
