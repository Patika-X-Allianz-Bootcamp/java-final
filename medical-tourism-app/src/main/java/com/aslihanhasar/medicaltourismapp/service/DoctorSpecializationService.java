package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.DoctorSpecializationSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.DoctorSpecializationSaveResponse;
import com.aslihanhasar.medicaltourismapp.entity.DoctorSpecialization;
import com.aslihanhasar.medicaltourismapp.exception.SpecializationAlreadySavedException;
import com.aslihanhasar.medicaltourismapp.exception.SpecializationNotFoundException;
import com.aslihanhasar.medicaltourismapp.exception.SpecializationValidationException;
import com.aslihanhasar.medicaltourismapp.repository.DoctorSpecializationRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Service class responsible for managing doctor specializations, including creation and retrieval of specializations.
 */
@Service
@RequiredArgsConstructor
public class DoctorSpecializationService {
    private final DoctorSpecializationRepository specializationRepository;

    /**
     * Creates a new doctor specialization based on the provided request and saves it to the database.
     *
     * @param request The request containing specialization details.
     * @return A response containing information about the created specialization.
     */
    @Transactional
    public DoctorSpecializationSaveResponse save(DoctorSpecializationSaveRequest request) {
        validateSpecializationSaveRequest(request);
        checkIsSpecializationAlreadySaved(request);
        DoctorSpecialization savedSpecialization = buildAndSaveSpecialization(request);
        return convertSpecializationToResponse(savedSpecialization);
    }

    /**
     * Retrieves a doctor specialization by its unique identifier (ID).
     *
     * @param id The unique identifier of the specialization.
     * @return The specialization with the specified ID.
     * @throws SpecializationNotFoundException If the specialization with the given ID is not found.
     */
    protected DoctorSpecialization getSpecializationById(Long id) {
        return specializationRepository.findById(id)
                .orElseThrow(() -> new SpecializationNotFoundException("Specialization not found."));
    }

    private DoctorSpecializationSaveResponse convertSpecializationToResponse(DoctorSpecialization specialization) {
        return DoctorSpecializationSaveResponse.builder()
                .specializationId(specialization.getId())
                .specialization(specialization.getName() + " - " + specialization.getDepartmentCode())
                .build();
    }

    private DoctorSpecialization buildAndSaveSpecialization(DoctorSpecializationSaveRequest request) {
        DoctorSpecialization specialization = DoctorSpecialization.builder()
                .name(request.getName())
                .departmentCode(request.getDepartmentCode())
                .build();
        return specializationRepository.save(specialization);
    }

    private void validateSpecializationSaveRequest(DoctorSpecializationSaveRequest request) {
        boolean anyFieldBlank = Stream.of(request.getName(),
                        request.getDepartmentCode())
                .anyMatch(StringUtils::isBlank);
        if (anyFieldBlank) {
            throw new SpecializationValidationException("Specialization code or name cannot be left blank");
        }
    }

    private void checkIsSpecializationAlreadySaved(DoctorSpecializationSaveRequest request) {
        String normalizedDepartmentName = request.getName().trim().toLowerCase();
        String normalizedDepartmentCode = request.getDepartmentCode().trim().toUpperCase();
        boolean exists = specializationRepository.existsByNameIgnoreCase(normalizedDepartmentName)
                || specializationRepository.existsByDepartmentCodeIgnoreCase(normalizedDepartmentCode);
        if (exists) {
            throw new SpecializationAlreadySavedException("A specialization with the same name or code already exists");
        }
    }
}
