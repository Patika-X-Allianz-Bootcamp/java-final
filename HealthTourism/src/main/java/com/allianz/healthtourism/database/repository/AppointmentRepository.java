package com.allianz.healthtourism.database.repository;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.model.DTO.AppointmentDTO;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourism.util.BaseRepository;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends BaseRepository<AppointmentEntity> {
}
