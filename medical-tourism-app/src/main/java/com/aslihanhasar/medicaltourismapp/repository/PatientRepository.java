package com.aslihanhasar.medicaltourismapp.repository;

import com.aslihanhasar.medicaltourismapp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByPatientNumber(String patientNumber);
}
