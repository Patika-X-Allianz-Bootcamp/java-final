package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.database.entity.RoomEntity;
import com.allianz.healthtourism.database.repository.HotelRepository;
import com.allianz.healthtourism.database.repository.RoomRepository;
import com.allianz.healthtourism.database.specification.HotelSpecification;
import com.allianz.healthtourism.database.specification.RoomSpecification;
import com.allianz.healthtourism.mapper.HotelMapper;
import com.allianz.healthtourism.mapper.RoomMapper;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.model.requestDTO.RoomRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HotelResponseDTO;
import com.allianz.healthtourism.model.responseDTO.RoomResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoomService extends BaseService<RoomResponseDTO, RoomRequestDTO, RoomEntity, RoomMapper, RoomRepository, RoomSpecification> {
    private final RoomRepository repository;
    private final RoomSpecification specification;

    @Override
    protected RoomMapper getMapper() {
        return RoomMapper.INSTANCE;
    }

    @Override
    protected RoomRepository getRepository() {
        return repository;
    }

    @Override
    protected RoomSpecification getSpecification() {
        return specification;
    }
}
