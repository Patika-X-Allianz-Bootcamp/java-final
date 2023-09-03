package com.allianz.meliorator.database.repository;

import com.allianz.meliorator.database.entity.Housing;
import com.allianz.meliorator.util_db.IBaseRepository;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingRepository extends IBaseRepository<Housing> {
}
