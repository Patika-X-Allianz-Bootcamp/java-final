package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.entity.BookingEntity;
import com.allianz.healthtourism.database.repository.AppointmentRepository;
import com.allianz.healthtourism.database.repository.BookingRepository;
import com.allianz.healthtourism.database.specification.AppointmentSpecification;
import com.allianz.healthtourism.database.specification.BookingSpecification;
import com.allianz.healthtourism.mapper.AppointmentMapper;
import com.allianz.healthtourism.mapper.BookingMapper;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourism.model.requestDTO.BookingRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.healthtourism.model.responseDTO.BookingResponseDTO;
import com.allianz.healthtourism.service.AppointmentService;
import com.allianz.healthtourism.service.BookingService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
@RequiredArgsConstructor
public class BookingController extends BaseController<BookingRequestDTO,
        BookingResponseDTO,
        BookingEntity,
        BookingMapper,
        BookingRepository,
        BookingSpecification,
        BookingService> {
    private final BookingService service;

    @Override
    protected BookingService getService() {
        return service;
    }


}
