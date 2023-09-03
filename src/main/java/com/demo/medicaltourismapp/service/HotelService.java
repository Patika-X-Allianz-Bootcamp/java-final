package com.demo.medicaltourismapp.service;

import com.demo.medicaltourismapp.database.entity.HotelEntity;
import com.demo.medicaltourismapp.database.repository.HotelRepository;
import com.demo.medicaltourismapp.mapper.HotelMapper;
import com.demo.medicaltourismapp.model.HotelDTO;
import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.model.requestDTO.HotelRequestDTO;
import com.demo.medicaltourismapp.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HotelService extends BaseService<HotelEntity, HotelDTO, HotelRequestDTO,
        HotelMapper, HotelRepository> {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;


    @Override
    protected HotelMapper getMapper() {
        return hotelMapper;
    }

    @Override
    protected HotelRepository getRepository() {
        return hotelRepository;
    }

    // we get hotels by city and where the capacity is not full
    public List<HotelDTO> getByCity(CityEnum cityEnum) {
        List<HotelEntity> hotelEntityList = hotelRepository.findByCityAndCapacityGreaterThan(cityEnum, 0);
        return hotelMapper.entityListToDtoList(hotelEntityList);
    }

    public HotelDTO getByNonZeroCapacityAndUuid(UUID uuid) {
        HotelEntity hotelEntity = hotelRepository.getAllByCapacityGreaterThanAndUuid(0, uuid);
        return hotelMapper.entityToDto(hotelEntity);
    }

}
