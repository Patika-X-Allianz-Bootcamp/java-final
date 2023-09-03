package com.demo.medicaltourismapp.database.repository;

import com.demo.medicaltourismapp.database.entity.PatientEntity;
import com.demo.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends BaseRepository<PatientEntity> {
}
