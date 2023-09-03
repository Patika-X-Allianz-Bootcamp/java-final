package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.HotelEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.HotelRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.HotelResponseDTO;
import com.burakcanciftci.healthtourism.service.HotelService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
@AllArgsConstructor
public class HotelController extends BaseController<HotelEntity, HotelResponseDTO, HotelRequestDTO> {
    private final HotelService hotelService;

    @Override
    protected HotelService getService() {
        return this.hotelService;
    }
}
