package com.allianz.medicaltourism.database.repository;

import com.allianz.medicaltourism.database.entity.DoctorEntity;
import com.allianz.medicaltourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorEntityRepository extends BaseRepository<DoctorEntity> {
	Optional<DoctorEntity> findByName(String name);

}
