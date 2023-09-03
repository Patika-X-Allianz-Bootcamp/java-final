package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.Hotel;
import com.allianz.patienttourism.model.requestDTO.HotelRequestDTO;
import com.allianz.patienttourism.model.responseDTO.HotelResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<Hotel, HotelResponseDTO, HotelRequestDTO> {
    public HotelController(BaseService<Hotel, HotelResponseDTO, HotelRequestDTO> service) {
        super(service);
    }
}
