package com.tourismcorp.healthtourism.database.repositories;

import com.tourismcorp.healthtourism.database.entities.DoctorEntity;
import com.tourismcorp.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends IBaseRepository<DoctorEntity> {
    Optional<DoctorEntity> findByUsername(String username);
}
