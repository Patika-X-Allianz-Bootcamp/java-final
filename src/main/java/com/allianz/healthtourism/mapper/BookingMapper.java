package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.entity.BookingEntity;
import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourism.model.requestDTO.BookingRequestDTO;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.healthtourism.model.responseDTO.BookingResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper extends BaseMapper<BookingEntity, BookingResponseDTO, BookingRequestDTO> {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Override
    @Mapping(source = "hotelId", target = "hotel.id")
    @Mapping(source = "patientId", target = "patient.id")
    @Mapping(source = "roomId", target = "room.id")
    BookingEntity requestDtoToEntity(BookingRequestDTO requestDTO);
}
