package com.allianz.HealthTourismSpringBoot.database.repositories;

import com.allianz.HealthTourismSpringBoot.database.entities.HotelEntity;
import com.allianz.HealthTourismSpringBoot.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends IBaseRepository<HotelEntity> {
}
