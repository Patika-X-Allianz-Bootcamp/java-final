package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.AddDoctorToHospitalRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.HospitalDetailResponse;
import com.aslihanhasar.medicaltourismapp.dto.request.HospitalSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.AddDoctorToHospitalResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.HospitalSaveResponse;
import com.aslihanhasar.medicaltourismapp.entity.City;
import com.aslihanhasar.medicaltourismapp.entity.Doctor;
import com.aslihanhasar.medicaltourismapp.entity.Hospital;
import com.aslihanhasar.medicaltourismapp.exception.*;
import com.aslihanhasar.medicaltourismapp.repository.HospitalRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Service class responsible for managing hospitals, including creation, retrieval, and operations related to hospitals.
 */
@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final CityService cityService;
    private final DoctorService doctorService;

    /**
     * Creates a new hospital based on the provided request and saves it to the database.
     *
     * @param request The request containing hospital details.
     * @return A response containing information about the created hospital.
     */
    @Transactional
    public HospitalSaveResponse save(HospitalSaveRequest request) {
        validateHospitalSaveRequest(request);
        checkIsHospitalAlreadySaved(request);
        Hospital savedHospital = buildAndSaveHospital(request);
        return convertHospitalToResponse(savedHospital);
    }

    /**
     * Adds a list of doctors to a hospital based on the provided request.
     *
     * @param request The request containing hospital ID and a list of doctor IDs to add.
     * @return A response containing the hospital ID and the IDs of the added doctors.
     */
    @Transactional
    public AddDoctorToHospitalResponse addDoctorToHospital(AddDoctorToHospitalRequest request) {
        Hospital hospital = getHospitalById(request.getHospitalId());
        Set<Doctor> doctors = doctorService.getDoctorsByIds(request.getDoctorIds());
        hospital.getDoctors().addAll(doctors);
        Hospital savedHospital = hospitalRepository.save(hospital);
        List<Long> savedDoctorIds = savedHospital.getDoctors().stream()
                .map(Doctor::getId)
                .toList();
        return AddDoctorToHospitalResponse.builder()
                .hospitalId(request.getHospitalId())
                .doctorIds(savedDoctorIds)
                .build();
    }

    /**
     * Retrieves a list of hospitals based on a search key.
     *
     * @param searchKey The search key to filter hospitals by code or name.
     * @return A list of hospital responses matching the search criteria.
     * @throws HospitalNotFoundException If no hospitals are found matching the search criteria.
     */
    public List<HospitalSaveResponse> getAllHospitals(String searchKey) {
        List<Hospital> hospitals = getHospitalsBySearchKey(searchKey);
        if (hospitals.isEmpty()) {
            throw new HospitalNotFoundException("No hospital found matching the search criteria.");
        }
        return hospitals.stream()
                .map(this::convertHospitalToResponse)
                .toList();
    }

    /**
     * Retrieves detailed information about a specific hospital, including its doctors.
     *
     * @param hospitalId The unique identifier of the hospital.
     * @return HospitalDetailResponse containing hospital and doctor details.
     */
    public HospitalDetailResponse getHospitalDetails(Long hospitalId) {
        Hospital hospital = getHospitalById(hospitalId);
        List<Doctor> doctors = new ArrayList<>(hospital.getDoctors());
        return HospitalDetailResponse.builder()
                .hospital(convertHospitalToResponse(hospital))
                .doctors(doctorService.convertDoctorsToResponses(doctors))
                .build();
    }

    /**
     * Retrieves a hospital by its unique identifier (ID).
     *
     * @param id The unique identifier of the hospital.
     * @return The hospital with the specified ID.
     * @throws HospitalNotFoundException If the hospital with the given ID is not found.
     */
    protected Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id)
                .orElseThrow(() -> new HospitalNotFoundException("Hospital Not Found."));
    }

    /**
     * Converts a Hospital object to a HospitalSaveResponse object.
     *
     * @param hospital The Hospital object to convert.
     * @return A HospitalSaveResponse containing hospital information.
     */
    protected HospitalSaveResponse convertHospitalToResponse(Hospital hospital) {
        return HospitalSaveResponse.builder()
                .hospitalId(hospital.getId())
                .hospital(hospital.getName() + " - " + hospital.getHospitalCode())
                .countryName(hospital.getCity().getCountry().getName())
                .cityName(hospital.getCity().getName())
                .build();
    }

    private Hospital buildAndSaveHospital(HospitalSaveRequest request) {
        City city = cityService.getCityById(request.getCityId());
        Hospital hospital = Hospital.builder()
                .name(request.getHospitalName())
                .hospitalCode(request.getHospitalCode())
                .city(city)
                .build();
        return hospitalRepository.save(hospital);
    }

    private List<Hospital> getHospitalsBySearchKey(String searchKey) {
        if (StringUtils.isBlank(searchKey)) {
            return hospitalRepository.findAll();
        } else {
            return hospitalRepository.findByHospitalCodeContainingIgnoreCaseOrNameContainingIgnoreCase(
                    searchKey, searchKey
            );
        }
    }

    private void validateHospitalSaveRequest(HospitalSaveRequest request) {
        boolean anyFieldBlank = Stream.of(request.getHospitalName(),
                        request.getHospitalCode(),
                        request.getCityId())
                .anyMatch(value -> value == null || value.toString().trim().isEmpty());
        if (anyFieldBlank) {
            throw new HospitalValidationException("Required fields cannot be left blank");
        }
    }

    private void checkIsHospitalAlreadySaved(HospitalSaveRequest request) {
        String normalizedHospitalCode = request.getHospitalCode().trim().toUpperCase();
        boolean exists = hospitalRepository.existsHospitalByHospitalCodeIgnoreCase(normalizedHospitalCode);
        if (exists) {
            throw new HospitalAlreadySavedException("Hospital with the same code already exists");
        }
    }

}
