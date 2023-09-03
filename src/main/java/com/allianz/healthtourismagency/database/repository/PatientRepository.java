package com.allianz.healthtourismagency.database.repository;

import com.allianz.healthtourismagency.database.entity.PatientEntity;
import com.allianz.healthtourismagency.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends IBaseRepository<PatientEntity> {
}
