package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.Booking;
import com.allianz.patienttourism.service.rules.BookingServiceRules;
import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.BookingRequestDTO;
import com.allianz.patienttourism.model.responseDTO.BookingResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService extends BaseService<Booking, BookingResponseDTO, BookingRequestDTO> {

    BookingServiceRules bookingServiceRules;


    public BookingService(IBaseRepository<Booking> repository, MapperService mapperService,
                          BaseSpecification<Booking> specification,BookingServiceRules bookingServiceRules) {
        super(repository, mapperService, specification);
        this.bookingServiceRules = bookingServiceRules;
    }

    @Override
    protected Class<Booking> getEntityClass() {
        return Booking.class;
    }

    @Override
    protected Class<BookingResponseDTO> getResponseDTOClass() {
        return BookingResponseDTO.class;
    }

    @Override
    public BookingResponseDTO save(BookingRequestDTO requestDTO) {
        bookingServiceRules.checkIfRoomOccupied(requestDTO.getRoomId(),requestDTO.getBookingDate());
        bookingServiceRules.checkIfPatientOccupied(requestDTO.getPatientId(),requestDTO.getBookingDate());
        return super.save(requestDTO);
    }
}
