package com.healthtourism.healthtourism.database.repositories;

import com.healthtourism.healthtourism.database.entities.HotelInfoEntity;
import com.healthtourism.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HotelInfoRepository extends IBaseRepository<HotelInfoEntity> {
}
