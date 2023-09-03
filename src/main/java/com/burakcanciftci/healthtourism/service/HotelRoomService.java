package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.HotelRoomEntity;
import com.burakcanciftci.healthtourism.database.repository.HotelRoomEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.HotelRoomSpecification;
import com.burakcanciftci.healthtourism.mapper.HotelRoomMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.HotelRoomPriceRequestDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.HotelRoomRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.HotelRoomResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class HotelRoomService extends BaseService<HotelRoomEntity, HotelRoomResponseDTO, HotelRoomRequestDTO> {

    private final HotelRoomEntityRepository hotelRoomEntityRepository;
    private final HotelRoomMapper hotelRoomMapper;
    private final HotelRoomSpecification hotelRoomSpecification;

    @Override
    protected HotelRoomMapper getMapper() {
        return this.hotelRoomMapper;
    }

    @Override
    protected HotelRoomEntityRepository getRepository() {
        return this.hotelRoomEntityRepository;
    }

    @Override
    protected HotelRoomSpecification getSpecification() {
        return hotelRoomSpecification;
    }

    public BigDecimal getPrice(HotelRoomPriceRequestDTO hotelRoomPriceRequestDTO) {
        Optional<HotelRoomEntity> hotelRoomEntityOptional = hotelRoomEntityRepository
                .findByUuid(hotelRoomPriceRequestDTO.getRoomUuid());

        if (hotelRoomEntityOptional.isPresent()) {
            return calculateTotalPrice(hotelRoomEntityOptional.get().getPricePerNight(),
                    hotelRoomPriceRequestDTO.getTotalDay());
        }

        return BigDecimal.valueOf(-1);
    }

    public static BigDecimal calculateTotalPrice(BigDecimal dailyPrice, int dayCount){
        return dailyPrice.multiply(BigDecimal.valueOf(dayCount));
    }
}