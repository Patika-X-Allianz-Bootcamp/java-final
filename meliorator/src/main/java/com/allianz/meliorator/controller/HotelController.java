package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Hotel;
import com.allianz.meliorator.database.repository.HotelRepository;
import com.allianz.meliorator.mapper.HotelMapper;
import com.allianz.meliorator.model.dto.HotelDTO;
import com.allianz.meliorator.model.requestDTO.HotelRequestDTO;
import com.allianz.meliorator.service.HotelService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController extends BaseController<Hotel, HotelDTO, HotelRequestDTO,
        HotelMapper, HotelRepository, HotelService> {
    @Autowired
    HotelService hotelService;


    @Override
    protected HotelService getService() {
        return this.hotelService;
    }
}
