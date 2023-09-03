package com.allianz.medicaltourism.database.repository;

import com.allianz.medicaltourism.database.entity.HotelEntity;
import com.allianz.medicaltourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelEntityRepository extends BaseRepository<HotelEntity> {
	Optional<HotelEntity> findByName(String name);

}
