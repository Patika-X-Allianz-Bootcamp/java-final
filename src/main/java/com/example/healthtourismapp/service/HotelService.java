package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.HotelEntity;
import com.example.healthtourismapp.database.entities.HotelRoomEntity;
import com.example.healthtourismapp.database.repositories.HotelRepository;
import com.example.healthtourismapp.database.repositories.HotelRoomRepository;
import com.example.healthtourismapp.database.specification.HotelSpecification;
import com.example.healthtourismapp.mapper.HotelMapper;
import com.example.healthtourismapp.mapper.HotelRoomMapper;
import com.example.healthtourismapp.model.HotelDTO;
import com.example.healthtourismapp.model.requestDTO.HotelRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService extends BaseService<
        HotelEntity,
        HotelDTO,
        HotelRequestDTO,
        HotelMapper,
        HotelRepository, HotelSpecification> {

    private final HotelMapper hotelMapper;
    private final HotelRepository hotelRepository;
    private final HotelSpecification hotelSpecification;


    public HotelService(HotelMapper hotelMapper, HotelRepository hotelRepository, HotelSpecification hotelSpecification) {
        this.hotelMapper = hotelMapper;
        this.hotelRepository = hotelRepository;
        this.hotelSpecification = hotelSpecification;
    }

    @Override
    public HotelMapper getMapper() {
        return hotelMapper;
    }

    @Override
    public HotelRepository getRepository() {
        return hotelRepository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return hotelSpecification;
    }

    public Optional<HotelRoomEntity> selectHotelRoomByUuid(UUID hotelUuid, UUID roomUuid) {
        Optional<HotelEntity> hotelOptional = hotelRepository.findByUuid(hotelUuid);
        if (hotelOptional.isPresent()) {
            HotelEntity hotel = hotelOptional.get();
            for (HotelRoomEntity room : hotel.getHotelRoomList()) {
                if (room.getUuid().equals(roomUuid)) {
                    return Optional.of(room);
                }
            }
        }
        return Optional.empty();
    }
}
