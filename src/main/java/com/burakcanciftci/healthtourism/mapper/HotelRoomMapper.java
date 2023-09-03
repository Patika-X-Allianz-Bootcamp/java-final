package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.HotelRoomEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.HotelRoomRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.HotelRoomResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class HotelRoomMapper extends BaseMapper<HotelRoomResponseDTO, HotelRoomEntity, HotelRoomRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(HotelRoomEntity.class, HotelRoomResponseDTO.class);
    }
}