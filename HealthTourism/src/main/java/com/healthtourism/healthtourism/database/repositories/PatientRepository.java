package com.healthtourism.healthtourism.database.repositories;

import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends IBaseRepository<PatientEntity> {
}
