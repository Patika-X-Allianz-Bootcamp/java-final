package com.aslihanhasar.medicaltourismapp.repository;

import com.aslihanhasar.medicaltourismapp.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    boolean existsHospitalByHospitalCodeIgnoreCase(String hospitalCode);

    List<Hospital> findByHospitalCodeContainingIgnoreCaseOrNameContainingIgnoreCase(
            String code, String name);
}
