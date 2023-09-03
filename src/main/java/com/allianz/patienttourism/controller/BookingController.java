package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.Booking;
import com.allianz.patienttourism.model.requestDTO.BookingRequestDTO;
import com.allianz.patienttourism.model.responseDTO.BookingResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
public class BookingController extends BaseController<Booking, BookingResponseDTO, BookingRequestDTO> {
    public BookingController(BaseService<Booking, BookingResponseDTO, BookingRequestDTO> service) {
        super(service);
    }
}
