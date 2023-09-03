package com.allianz.healthtourism.database.repository;

import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.util.dbutil.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends BaseRepository<HospitalEntity> {
}
