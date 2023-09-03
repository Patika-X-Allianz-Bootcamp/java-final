package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.HotelEntity;
import com.burakcanciftci.healthtourism.database.repository.HotelEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.HotelSpecification;
import com.burakcanciftci.healthtourism.mapper.HotelMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.HotelRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.HotelResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HotelService extends BaseService<HotelEntity, HotelResponseDTO, HotelRequestDTO> {

    private final HotelEntityRepository hotelEntityRepository;
    private final HotelMapper hotelMapper;
    private final HotelSpecification hotelSpecification;

    @Override
    protected HotelMapper getMapper() {
        return this.hotelMapper;
    }

    @Override
    protected HotelEntityRepository getRepository() {
        return this.hotelEntityRepository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return hotelSpecification;
    }
}