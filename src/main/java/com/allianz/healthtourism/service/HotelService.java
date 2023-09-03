package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.database.entity.RoomEntity;
import com.allianz.healthtourism.database.repository.HotelRepository;
import com.allianz.healthtourism.database.specification.HotelSpecification;
import com.allianz.healthtourism.mapper.HospitalMapper;
import com.allianz.healthtourism.mapper.HotelMapper;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.model.requestDTO.RoomRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HotelForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HotelResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class HotelService extends BaseService<HotelResponseDTO, HotelRequestDTO, HotelEntity, HotelMapper, HotelRepository, HotelSpecification> {
    private final HotelRepository repository;
    private final HotelSpecification specification;

    @Override
    protected HotelMapper getMapper() {
        return HotelMapper.INSTANCE;
    }

    @Override
    protected HotelRepository getRepository() {
        return repository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return specification;
    }

    @Override
    public HotelResponseDTO save(HotelRequestDTO requestDTO) {
        List<RoomEntity> roomEntities = new ArrayList<>();
        for(int i = 0; i < requestDTO.getRoomCount(); i++){
            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setRoomNo(i+1);
            roomEntities.add(roomEntity);
        }
        HotelEntity hotelEntity = getMapper().requestDtoToEntity(requestDTO);
        hotelEntity.setRooms(roomEntities);
        hotelEntity = getRepository().save(hotelEntity);
        return getMapper().entityToResponseDto(hotelEntity);
    }

    public List<HotelForPatientResponseDTO> findByCityName(String cityName){
        List<HotelEntity> hotelEntities = getRepository().findByCityName(cityName);
        return getMapper().entityListToResponseDtoListForPatient(hotelEntities);
    }

    public HotelEntity findById(Long hotelId) {
        return getRepository().findById(hotelId).orElse(null);
    }
}
