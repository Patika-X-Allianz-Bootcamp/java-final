package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.HotelReservationEntity;
import com.allianz.healthtourismagency.model.HotelReservationDTO;
import com.allianz.healthtourismagency.model.requestDTO.HotelReservationRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelReservationMapper extends IBaseMapper<HotelReservationEntity, HotelReservationDTO, HotelReservationRequestDTO> {

}
