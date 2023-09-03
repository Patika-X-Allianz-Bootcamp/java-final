package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.SeatReservationEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.SeatReservationRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.SeatReservationResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SeatReservationMapper
        extends BaseMapper<SeatReservationResponseDTO, SeatReservationEntity, SeatReservationRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(SeatReservationEntity.class, SeatReservationResponseDTO.class);
    }
}