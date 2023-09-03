package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.HotelSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.*;
import com.aslihanhasar.medicaltourismapp.entity.Hotel;
import com.aslihanhasar.medicaltourismapp.enums.HotelStatus;
import com.aslihanhasar.medicaltourismapp.exception.*;
import com.aslihanhasar.medicaltourismapp.repository.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

/**
 * Service class responsible for managing hotels, including creation, retrieval, and operations related to hotels.
 */
@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    private final CityService cityService;

    /**
     * Creates a new hotel based on the provided request and saves it to the database.
     *
     * @param request The request containing hotel details.
     * @return A response containing information about the created hotel.
     */
    @Transactional
    public HotelSaveResponse save(HotelSaveRequest request) {
        validateHotelSaveRequest(request);
        Hotel savedHotel = buildHotelAndSave(request);
        return convertHotelToResponse(savedHotel);
    }

    /**
     * Retrieves a list of hotels based on optional search criteria, including hotel name and city name.
     *
     * @param nameKey     The optional search key for hotel names.
     * @param cityNameKey The optional search key for city names.
     * @return A list of hotel responses matching the search criteria.
     * @throws HotelNotFoundException If no hotels are found matching the search criteria.
     */
    public List<HotelSearchResponse> getAllHotels(String nameKey, String cityNameKey) {
        List<Hotel> hotels;
        if (nameKey.isEmpty() && cityNameKey.isEmpty()) {
            hotels = hotelRepository.findAll();
        } else {
            hotels = hotelRepository.
                    findByNameContainingIgnoreCaseOrCity_NameContainingIgnoreCase(nameKey, cityNameKey);
        }
        if (hotels.isEmpty()) {
            throw new HotelNotFoundException("Hotel not found.");
        }
        return hotels.stream()
                .map(this::convertHotelToSearchResponse)
                .toList();
    }

    /**
     * Reserves a specified number of rooms in a hotel.
     *
     * @param hotel          The hotel to reserve rooms in.
     * @param requestedRooms The number of rooms to reserve.
     * @throws NotAvailableRoomException If there are not enough available rooms for reservation.
     */
    protected void reserveRoom(Hotel hotel, int requestedRooms) {
        boolean availableRooms = isAvailableCapacity(hotel, requestedRooms);
        if (!availableRooms) {
            throw new NotAvailableRoomException("Not enough available rooms.");
        }
        int remainingCapacity = hotel.getRemainingCapacity();
        hotel.setRemainingCapacity(remainingCapacity - requestedRooms);
        hotel.setRemainingRooms(remainingCapacity - requestedRooms);
        hotelRepository.save(hotel);
    }

    /**
     * Confirms a hotel reservation based on the reservation number.
     *
     * @param reservationNumber The reservation number to confirm.
     */
    protected void confirmHotelReservation(String reservationNumber) {
        Hotel hotelByNumber = getByReservationNumber(reservationNumber);
        if (hotelByNumber.getHotelStatus() == HotelStatus.RESERVED) {
            hotelByNumber.setHotelStatus(HotelStatus.CONFIRMED);
            hotelRepository.save(hotelByNumber);
        } else if (hotelByNumber.getHotelStatus() == HotelStatus.CONFIRMED) {
            throw new HotelReservationAlreadyConfirmedException("Appointment already confirmed.");
        }
    }

    /**
     * Schedules the confirmation of a hotel reservation after a certain time period.
     *
     * @param hotel          The hotel with the reservation to confirm.
     * @param requestedRooms The number of rooms reserved.
     */
    protected void scheduleHotelConfirmation(Hotel hotel, int requestedRooms) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (hotel.getHotelStatus() == HotelStatus.RESERVED) {
                    hotel.setHotelStatus(HotelStatus.CANCELED);
                    updateAvailableCapacity(hotel, requestedRooms);
                    hotelRepository.save(hotel);
                }
            }
        }, 10 * 60 * 1000);
    }

    /**
     * Retrieves a hotel by its unique identifier (ID).
     *
     * @param id The unique identifier of the hotel.
     * @return The hotel with the specified ID.
     * @throws HotelNotFoundException If the hotel with the given ID is not found.
     */
    protected Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found."));
    }

    private Hotel getByReservationNumber(String reservationNumber) {
        return hotelRepository.findByReservationNumber(reservationNumber)
                .orElseThrow(() -> new HotelNotFoundException("Reservation not found."));

    }

    private HotelSaveResponse convertHotelToResponse(Hotel hotel) {
        return HotelSaveResponse
                .builder()
                .hotelId(hotel.getId())
                .hotel(hotel.getName() + " - " + hotel.getHotelCode())
                .city(cityService.convertCityToResponse(hotel.getCity()))
                .roomCount(hotel.getRoomCount())
                .totalCapacity(hotel.getTotalCapacity())
                .hotelPricePerNight(hotel.getHotelPricePerNight())
                .build();
    }

    private void updateAvailableCapacity(Hotel hotel, int requestedRooms) {
        int currentAvailableRooms = hotel.getRemainingRooms();
        int currentAvailableCapacity = hotel.getRemainingCapacity();
        int updatedAvailableRooms = currentAvailableRooms + requestedRooms;
        int updatedAvailableCapacity = currentAvailableCapacity + requestedRooms;
        hotel.setRemainingRooms(updatedAvailableRooms);
        hotel.setRemainingCapacity(updatedAvailableCapacity);
        hotelRepository.save(hotel);
    }

    private HotelSearchResponse convertHotelToSearchResponse(Hotel hotel) {
        return HotelSearchResponse
                .builder()
                .hotelId(hotel.getId())
                .hotel(hotel.getName() + " - " + hotel.getHotelCode())
                .city(hotel.getCity().getName() + " - " + hotel.getCity().getCountry().getName())
                .hotelPricePerNight(hotel.getHotelPricePerNight())
                .build();
    }

    private Hotel buildHotelAndSave(HotelSaveRequest request) {
        checkIsHotelAlreadyExist(request);
        Hotel hotel = Hotel
                .builder()
                .name(request.getName())
                .hotelCode(request.getHotelCode())
                .city(cityService.getCityById(request.getCityId()))
                .roomCount(request.getRoomCount())
                .totalCapacity(request.getTotalCapacity())
                .hotelPricePerNight(request.getHotelPricePerNight())
                .build();
        return hotelRepository.save(hotel);
    }

    private boolean isAvailableCapacity(Hotel hotel, int requestedRooms) {
        return hotel.getRemainingCapacity() >= requestedRooms;
    }

    private void checkIsHotelAlreadyExist(HotelSaveRequest request) {
        boolean existHotel = hotelRepository.existsByHotelCodeAndCityId(
                request.getHotelCode(), request.getCityId());
        if (existHotel) {
            throw new DuplicateHotelCodeException("A hotel with the same code already exists in the city.");
        }
    }

    private void validateHotelSaveRequest(HotelSaveRequest request) {
        boolean anyFieldBlank = Stream.of(request.getName(),
                        request.getHotelCode(),
                        request.getCityId(),
                        request.getRoomCount(),
                        request.getTotalCapacity(),
                        request.getHotelPricePerNight())
                .anyMatch(value -> value == null || value.toString().trim().isEmpty());
        if (anyFieldBlank) {
            throw new HotelValidationException("Required fields cannot be left blank");
        }
        if (request.getTotalCapacity() < 20) {
            throw new HotelValidationException("Capacity is invalid");
        }
        if (request.getRoomCount() != request.getTotalCapacity()) {
            throw new HotelValidationException("the number of rooms is equal to the total capacity");
        }
    }
}
