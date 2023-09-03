package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.HotelRoomEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.ExaminationRequestDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.HotelRoomPriceRequestDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.HotelRoomRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.ExaminationResponseDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.HotelRoomResponseDTO;
import com.burakcanciftci.healthtourism.service.HotelRoomService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("hotel-room")
@AllArgsConstructor
public class HotelRoomController extends BaseController<HotelRoomEntity, HotelRoomResponseDTO, HotelRoomRequestDTO> {
    private final HotelRoomService hotelRoomService;

    @Override
    protected HotelRoomService getService() {
        return this.hotelRoomService;
    }

    @PostMapping("get-price")
    public ResponseEntity<BigDecimal> reserveSeat(
            @RequestBody HotelRoomPriceRequestDTO hotelRoomPriceRequestDTO){
        BigDecimal price =
                hotelRoomService.getPrice(hotelRoomPriceRequestDTO);

        if(price.compareTo(BigDecimal.ZERO) > 1){
            return new ResponseEntity<>(price, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
