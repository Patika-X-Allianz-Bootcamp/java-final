package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.CitySaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.CitySaveResponse;
import com.aslihanhasar.medicaltourismapp.entity.City;
import com.aslihanhasar.medicaltourismapp.entity.Country;
import com.aslihanhasar.medicaltourismapp.exception.*;
import com.aslihanhasar.medicaltourismapp.repository.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Service class responsible for managing cities, including creation and retrieval of cities.
 */
@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CountryService countryService;

    /**
     * Creates a new city based on the provided request and saves it to the database.
     *
     * @param request The request containing city details.
     * @return A response containing information about the created city.
     */
    @Transactional
    public CitySaveResponse save(CitySaveRequest request) {
        validateCitySaveRequest(request);
        checkIsCityAlreadySaved(request);
        City savedCity = buildAndSaveCity(request);
        return convertCityToResponse(savedCity);
    }

    /**
     * Retrieves a city by its unique identifier (ID).
     *
     * @param id The unique identifier of the city.
     * @return The city with the specified ID.
     * @throws CityNotFoundException If the city with the given ID is not found.
     */
    protected City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found."));
    }

    /**
     * Converts a City object to a CitySaveResponse object.
     *
     * @param city The City object to convert.
     * @return A CitySaveResponse containing city information.
     */
    protected CitySaveResponse convertCityToResponse(City city) {
        return CitySaveResponse.builder()
                .cityId(city.getId())
                .cityName(city.getName())
                .countryName(city.getCountry().getName())
                .build();
    }

    private City buildAndSaveCity(CitySaveRequest request) {
        Country country = countryService.getCountryById(request.getCountryId());
        City city = City.builder()
                .name(request.getCityName())
                .country(country)
                .build();
        return cityRepository.save(city);
    }

    private void validateCitySaveRequest(CitySaveRequest request) {
        boolean anyFieldBlank = Stream.of(request.getCityName(),
                        request.getCountryId())
                .anyMatch(value -> value == null || value.toString().trim().isEmpty());
        if (anyFieldBlank) {
            throw new CityValidationException("Required fields cannot be left blank");
        }
    }

    private void checkIsCityAlreadySaved(CitySaveRequest request) {
        String normalizedCountryName = request.getCityName().trim().toLowerCase();
        boolean exists = cityRepository.existsByNameAndCountry_Id
                (normalizedCountryName, request.getCountryId());
        if (exists) {
            throw new CityAlreadySavedException("City already exists in the country");
        }
    }
}
