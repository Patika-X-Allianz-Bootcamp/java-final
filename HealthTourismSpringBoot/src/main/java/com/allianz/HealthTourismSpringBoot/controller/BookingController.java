package com.allianz.HealthTourismSpringBoot.controller;

import com.allianz.HealthTourismSpringBoot.database.entities.BookingEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.BookingRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.BookingSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.BookingMapper;
import com.allianz.HealthTourismSpringBoot.model.BookingDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.BookingRequestDTO;
import com.allianz.HealthTourismSpringBoot.service.BookingService;
import com.allianz.HealthTourismSpringBoot.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/booking")
public class BookingController extends BaseController<BookingEntity,
        BookingDTO,
        BookingRequestDTO,
        BookingMapper,
        BookingRepository,
        BookingSpecification,
        BookingService> {

    @Autowired
    BookingService bookingService;

    @Override
    protected BookingService getService() {
        return bookingService;
    }


}
