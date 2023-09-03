package com.example.healthtourismapp.database.repositories;

import com.example.healthtourismapp.database.entities.PatientEntity;
import com.example.healthtourismapp.util.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends IBaseRepository<PatientEntity> {

    Optional<PatientEntity> findByUsername(String username);
}
