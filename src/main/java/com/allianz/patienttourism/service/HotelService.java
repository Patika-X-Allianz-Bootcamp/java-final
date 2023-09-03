package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.Hotel;
import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.HotelRequestDTO;
import com.allianz.patienttourism.model.responseDTO.HotelResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends BaseService<Hotel, HotelResponseDTO, HotelRequestDTO> {


    public HotelService(IBaseRepository<Hotel> repository, MapperService mapperService, BaseSpecification<Hotel> specification) {
        super(repository, mapperService, specification);
    }

    @Override
    protected Class<Hotel> getEntityClass() {
        return Hotel.class;
    }

    @Override
    protected Class<HotelResponseDTO> getResponseDTOClass() {
        return HotelResponseDTO.class;
    }
}
