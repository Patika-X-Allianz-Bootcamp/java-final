package com.patika.healthtourism.service;

import com.patika.healthtourism.database.entity.FlightEntity;
import com.patika.healthtourism.database.entity.HotelEntity;
import com.patika.healthtourism.database.repository.HotelEntityRepository;
import com.patika.healthtourism.mapper.HotelMapper;
import com.patika.healthtourism.model.HotelDTO;
import com.patika.healthtourism.model.requestDTO.HotelRequestDTO;
import com.patika.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService extends BaseService<HotelEntity, HotelDTO, HotelRequestDTO, HotelMapper, HotelEntityRepository> {
    private final HotelEntityRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelService(HotelEntityRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    @Override
    protected HotelMapper getMapper() {
        return hotelMapper;
    }

    @Override
    protected HotelEntityRepository getRepository() {
        return hotelRepository;
    }

    public List<HotelDTO> getAvailableHotels(LocalDateTime selectedAppointmentDate) {
        Optional<List<HotelEntity>> hotels = hotelRepository
                .findByCheckInDateBefore(selectedAppointmentDate.toLocalDate());

        return hotels.map(hotelEntities -> getMapper().entityListToDtoList(hotelEntities)).orElse(null);
    }

}
