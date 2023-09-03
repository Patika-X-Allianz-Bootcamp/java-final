package com.allianz.healthtourism.database.repository;

import com.allianz.healthtourism.database.entity.BookingEntity;
import com.allianz.healthtourism.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends BaseRepository<BookingEntity> {
}
