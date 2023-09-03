package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.CountrySaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.CountrySaveResponse;
import com.aslihanhasar.medicaltourismapp.entity.Country;
import com.aslihanhasar.medicaltourismapp.exception.*;
import com.aslihanhasar.medicaltourismapp.repository.CountryRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Service class responsible for managing countries, including creation and retrieval of countries.
 */
@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    /**
     * Creates a new country based on the provided request and saves it to the database.
     *
     * @param request The request containing country details.
     * @return A response containing information about the created country.
     */
    @Transactional
    public CountrySaveResponse save(CountrySaveRequest request) {
        validateCountrySaveRequest(request);
        checkIsCountryAlreadySaved(request);
        Country savedCountry = buildAndSaveCountry(request);
        return convertCountryToResponse(savedCountry);
    }

    /**
     * Retrieves a country by its unique identifier (ID).
     *
     * @param id The unique identifier of the country.
     * @return The country with the specified ID.
     * @throws CountryNotFoundException If the country with the given ID is not found.
     */
    protected Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException("Country not found."));
    }

    private CountrySaveResponse convertCountryToResponse(Country country) {
        return CountrySaveResponse.builder()
                .countryId(country.getId())
                .countryName(country.getName())
                .build();
    }

    private Country buildAndSaveCountry(CountrySaveRequest request) {
        Country country = Country.builder()
                .name(request.getCountryName())
                .build();
        return countryRepository.save(country);
    }

    private void validateCountrySaveRequest(CountrySaveRequest request) {
        boolean anyFieldBlank = Stream.of(request.getCountryName())
                .anyMatch(StringUtils::isBlank);
        if (anyFieldBlank) {
            throw new CountryValidationException("Country name cannot be left blank");
        }
    }

    private void checkIsCountryAlreadySaved(CountrySaveRequest request) {
        String normalizedCountryName = request.getCountryName().trim().toLowerCase();
        boolean exists = countryRepository.existsByNameIgnoreCase(normalizedCountryName);
        if (exists) {
            throw new CountryAlreadySavedException("Country already exists");
        }
    }
}
