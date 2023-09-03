package com.allianz.HealthTourismSpringBoot.service;

import com.allianz.HealthTourismSpringBoot.database.entities.BookingEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.BookingRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.BookingSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.BookingMapper;
import com.allianz.HealthTourismSpringBoot.model.BookingDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.BookingRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingService extends BaseService<
        BookingEntity,
        BookingDTO,
        BookingRequestDTO,
        BookingMapper,
        BookingRepository,
        BookingSpecification> {

    @Autowired
    BookingMapper bookingMapper;

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BookingSpecification bookingSpecification;

    @Override
    public BookingMapper getMapper() {
        return bookingMapper;
    }

    @Override
    public BookingRepository getRepository() {
        return bookingRepository;
    }

    @Override
    protected BookingSpecification getSpecification() {
        return bookingSpecification;
    }


}
