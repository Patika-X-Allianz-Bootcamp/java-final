package com.allianz.HealthTourismSpringBoot.database.repositories;

import com.allianz.HealthTourismSpringBoot.database.entities.AirlineEntity;
import com.allianz.HealthTourismSpringBoot.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends IBaseRepository<AirlineEntity> {
}
