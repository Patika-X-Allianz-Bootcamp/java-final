package com.aslihanhasar.medicaltourismapp.repository;

import com.aslihanhasar.medicaltourismapp.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    boolean existsByNameAndCountry_Id(String cityName, Long countryId);
}
