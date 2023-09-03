package com.allianz.medicaltourism.database.repository;

import com.allianz.medicaltourism.database.entity.PatientEntity;
import com.allianz.medicaltourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientEntityRepository extends BaseRepository<PatientEntity> {
	Optional<PatientEntity> findByName(String name);

}
