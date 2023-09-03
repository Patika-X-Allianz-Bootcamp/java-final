package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.RoomReservationEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.RoomReservationRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.RoomReservationResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class RoomReservationMapper
        extends BaseMapper<RoomReservationResponseDTO, RoomReservationEntity, RoomReservationRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(RoomReservationEntity.class, RoomReservationResponseDTO.class);
    }
}