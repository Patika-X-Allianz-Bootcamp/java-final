package com.allianz.medicaltourism.database.repository;

import com.allianz.medicaltourism.database.entity.HospitalEntity;
import com.allianz.medicaltourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalEntityRepository extends BaseRepository<HospitalEntity> {
	Optional<HospitalEntity> findByName(String name);

}
