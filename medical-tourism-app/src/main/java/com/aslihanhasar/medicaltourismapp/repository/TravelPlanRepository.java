package com.aslihanhasar.medicaltourismapp.repository;

import com.aslihanhasar.medicaltourismapp.entity.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TravelPlanRepository extends JpaRepository<TravelPlan, Long> {
}
