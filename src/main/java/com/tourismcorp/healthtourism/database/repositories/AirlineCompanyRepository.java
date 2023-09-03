package com.tourismcorp.healthtourism.database.repositories;

import com.tourismcorp.healthtourism.database.entities.AirlineCompanyEntity;
import com.tourismcorp.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineCompanyRepository extends IBaseRepository<AirlineCompanyEntity> {
    AirlineCompanyEntity findByCompanyName(String name);
}
