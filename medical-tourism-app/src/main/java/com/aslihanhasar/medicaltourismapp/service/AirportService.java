package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.AddAirlineToAirportRequest;
import com.aslihanhasar.medicaltourismapp.dto.request.AirportSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.AddAirlineToAirportResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.AirportDetailResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.AirportSaveResponse;
import com.aslihanhasar.medicaltourismapp.entity.Airline;
import com.aslihanhasar.medicaltourismapp.entity.Airport;
import com.aslihanhasar.medicaltourismapp.exception.AirportAlreadySaveException;
import com.aslihanhasar.medicaltourismapp.exception.AirportNotFoundException;
import com.aslihanhasar.medicaltourismapp.exception.AirportValidationException;
import com.aslihanhasar.medicaltourismapp.repository.AirportRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The AirportService class is a service that manages operations related to airports, such as saving, retrieving, and associating airlines
 * with airports. It interacts with the AirportRepository for data storage and the AirlineService for airline-related operations.
 */
@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
    private final AirlineService airlineService;
    private final CityService cityService;

    /**
     * Saves an airport based on the provided AirportSaveRequest.
     *
     * @param request The AirportSaveRequest containing the details of the airport to be saved.
     * @return An AirportSaveResponse indicating the result of the save operation.
     * @throws AirportValidationException  If any of the provided request fields are empty or blank.
     * @throws AirportAlreadySaveException If an airport with the same name or code already exists.
     */
    @Transactional
    public AirportSaveResponse save(AirportSaveRequest request) {
        validateAirportSaveRequest(request);
        checkIsAirportAlreadySaved(request);
        Airport savedAirport = buildAndSaveAirport(request);
        return convertAirportToResponse(savedAirport);
    }

    /**
     * Retrieves a list of airports based on the provided search key.
     *
     * @param searchKey The search key to filter airports by name or code.
     * @return A list of AirportSaveResponse objects representing the retrieved airports.
     * @throws AirportNotFoundException If no airports are found matching the search criteria.
     */
    public List<AirportSaveResponse> getAllAirports(String searchKey) {
        List<Airport> airports = getAirportsBySearchKey(searchKey);
        if (airports.isEmpty()) {
            throw new AirportNotFoundException("No airports found matching the search criteria.");
        }
        return airports.stream()
                .map(this::convertAirportToResponse)
                .toList();
    }

    /**
     * Retrieves detailed information about an airport, including associated airlines.
     *
     * @param airportId The ID of the airport to retrieve details for.
     * @return An AirportDetailResponse containing information about the airport and associated airlines.
     */
    public AirportDetailResponse getAirportDetails(Long airportId) {
        Airport airport = getAirportById(airportId);
        List<Airline> airlines = new ArrayList<>(airport.getAirlines());
        return AirportDetailResponse.builder()
                .airport(convertAirportToResponse(airport))
                .airlines(airlineService.convertAirlinesToResponses(airlines))
                .build();
    }

    /**
     * Associates airlines with an airport and saves the updated airport information.
     *
     * @param request The AddAirlineToAirportRequest containing the airport ID and airline IDs to associate.
     * @return An AddAirlineToAirportResponse indicating the result of the operation.
     */
    @Transactional
    public AddAirlineToAirportResponse addAirlineToAirport(AddAirlineToAirportRequest request) {
        Airport airport = getAirportById(request.getAirportId());
        Set<Airline> airlines = airlineService.getAirlinesByIds(request.getAirlineIds());
        airport.getAirlines().addAll(airlines);
        Airport savedAirport = airportRepository.save(airport);
        List<Long> savedAirlineIds = savedAirport.getAirlines().stream()
                .map(Airline::getId)
                .collect(Collectors.toList());
        return AddAirlineToAirportResponse.builder()
                .airportId(request.getAirportId())
                .airlineIds(savedAirlineIds)
                .build();
    }


    /**
     * Checks if an airport exists based on the provided airport ID.
     *
     * @param airportId The ID of the airport to check for existence.
     * @throws AirportNotFoundException If no airport is found with the provided ID.
     */
    public void checkIsAirportExist(Long airportId) {
        boolean existAirport = airportRepository.existsById(airportId);
        if (!existAirport) {
            throw new AirportNotFoundException("Airport not found with id");
        }
    }

    protected Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new AirportNotFoundException("Airport Not Found."));
    }

    protected AirportSaveResponse convertAirportToResponse(Airport airport) {
        return AirportSaveResponse.builder()
                .airportId(airport.getId())
                .airport(airport.getAirportName() + " - " + airport.getAirportCode())
                .airportLocation(cityService.convertCityToResponse(airport.getCity()))
                .build();
    }

    private List<Airport> getAirportsBySearchKey(String searchKey) {
        if (StringUtils.isBlank(searchKey)) {
            return airportRepository.findAll();
        } else {
            return airportRepository.findByAirportCodeContainingIgnoreCaseOrAirportNameContainingIgnoreCase(
                    searchKey, searchKey
            );
        }
    }

    private Airport buildAndSaveAirport(AirportSaveRequest request) {
        Airport airport = Airport.builder()
                .airportName(request.getAirportName())
                .airportCode(request.getAirportCode())
                .city(cityService.getCityById(request.getCityId()))
                .build();
        return airportRepository.save(airport);
    }

    private void validateAirportSaveRequest(AirportSaveRequest request) {
        boolean anyFieldBlank = Stream.of(request.getAirportCode(),
                        request.getAirportName(),
                        request.getCityId())
                .anyMatch(value -> value == null || value.toString().trim().isEmpty());
        if (anyFieldBlank) {
            throw new AirportValidationException("Airport name, airport code and " +
                    "location cannot be left blank");
        }
    }

    private void checkIsAirportAlreadySaved(AirportSaveRequest request) {
        String normalizedAirportName = request.getAirportName().trim().toLowerCase();
        String normalizedAirportCode = request.getAirportCode().trim().toUpperCase();
        boolean exists = airportRepository.existsByAirportNameIgnoreCase(normalizedAirportName)
                || airportRepository.existsByAirportCodeIgnoreCase(normalizedAirportCode);
        if (exists) {
            throw new AirportAlreadySaveException("An airport with the same name or code already exists");
        }
    }
}
