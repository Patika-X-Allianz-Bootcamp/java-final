package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.DoctorSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.DoctorSaveResponse;
import com.aslihanhasar.medicaltourismapp.entity.Appointment;
import com.aslihanhasar.medicaltourismapp.entity.Doctor;
import com.aslihanhasar.medicaltourismapp.entity.DoctorSpecialization;
import com.aslihanhasar.medicaltourismapp.exception.*;
import com.aslihanhasar.medicaltourismapp.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Service class responsible for managing doctors, including creation and retrieval of doctors.
 */
@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorSpecializationService specializationService;

    /**
     * Creates a new doctor based on the provided request and saves it to the database.
     *
     * @param request The request containing doctor details.
     * @return A response containing information about the created doctor.
     */
    @Transactional
    public DoctorSaveResponse save(DoctorSaveRequest request) {
        validateDoctorSaveRequest(request);
        Doctor savedDoctor = buildAndSaveDoctor(request);
        return convertDoctorToResponse(savedDoctor);
    }

    /**
     * Converts a list of Doctor objects to a list of DoctorSaveResponse objects.
     *
     * @param doctors The list of Doctor objects to convert.
     * @return A list of DoctorSaveResponse objects containing doctor information.
     */
    protected List<DoctorSaveResponse> convertDoctorsToResponses(List<Doctor> doctors) {
        return doctors.stream()
                .map(this::convertDoctorToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a set of doctors by their unique identifiers (IDs).
     *
     * @param doctorIds The set of unique identifiers of the doctors.
     * @return A set of doctors with the specified IDs.
     * @throws DoctorNotFoundException If a doctor with any of the given IDs is not found.
     */
    protected Set<Doctor> getDoctorsByIds(Set<Long> doctorIds) {
        Set<Doctor> doctors = doctorRepository.findAllById(doctorIds)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        if (doctors.size() < doctorIds.size()) {
            throw new HospitalNotFoundException("Invalid id.");
        }
        return doctors;
    }

    /**
     * Retrieves a doctor by their unique identifier (ID).
     *
     * @param id The unique identifier of the doctor.
     * @return The doctor with the specified ID.
     * @throws DoctorNotFoundException If the doctor with the given ID is not found.
     */
    protected Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found."));
    }

    /**
     * Converts a Doctor object to a DoctorSaveResponse object.
     *
     * @param doctor The Doctor object to convert.
     * @return A DoctorSaveResponse containing doctor information.
     */
    protected DoctorSaveResponse convertDoctorToResponse(Doctor doctor) {
        return DoctorSaveResponse.builder()
                .doctorId(doctor.getId())
                .doctor(doctor.getFirstName() + " " + doctor.getLastName())
                .specialization(doctor.getSpecialization().getName() + " - "
                        + doctor.getSpecialization().getDepartmentCode())
                .build();
    }

    /**
     * Adds an appointment to a doctor's list of appointments and updates the database.
     *
     * @param doctor      The doctor to whom the appointment is added.
     * @param appointment The appointment to add to the doctor.
     */
    protected void addAppointmentToDoctor(Doctor doctor, Appointment appointment) {
        List<Appointment> appointments = doctor.getAppointments();
        appointments.add(appointment);
        doctor.setAppointments(appointments);
        doctorRepository.save(doctor);
    }

    private Doctor buildAndSaveDoctor(DoctorSaveRequest request) {
        DoctorSpecialization specialization = specializationService
                .getSpecializationById(request.getSpecializationId());
        Doctor doctor = Doctor.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .specialization(specialization)
                .build();
        return doctorRepository.save(doctor);
    }

    private void validateDoctorSaveRequest(DoctorSaveRequest request) {
        boolean anyFieldBlank = Stream.of(request.getFirstName(),
                        request.getLastName(),
                        request.getSpecializationId())
                .anyMatch(value -> value == null || value.toString().trim().isEmpty());
        if (anyFieldBlank) {
            throw new DoctorValidationException("Required fields cannot be left blank");
        }
    }
}
