package com.allianz.meliorator.database.repository;

import com.allianz.meliorator.database.entity.Hospital;
import com.allianz.meliorator.database.entity.Hotel;
import com.allianz.meliorator.util_db.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends IBaseRepository<Hotel> {
}
