package com.aslihanhasar.medicaltourismapp.repository;

import com.aslihanhasar.medicaltourismapp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    boolean existsByHotelCodeAndCityId(String hotelCode, Long cityId);

    Optional<Hotel> findByReservationNumber(String reservationNumber);


    List<Hotel> findByNameContainingIgnoreCaseOrCity_NameContainingIgnoreCase
            (String hotelName, String cityName);
}
