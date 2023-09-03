package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.BookingEntity;
import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.database.repository.BookingRepository;
import com.allianz.healthtourism.database.specification.BookingSpecification;
import com.allianz.healthtourism.mapper.BookingMapper;
import com.allianz.healthtourism.model.requestDTO.BookingRequestDTO;
import com.allianz.healthtourism.model.responseDTO.BookingResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BookingService extends BaseService<BookingResponseDTO, BookingRequestDTO, BookingEntity, BookingMapper, BookingRepository, BookingSpecification> {
    private final BookingRepository repository;
    private final BookingSpecification specification;
    private final HotelService hotelService;

    @Override
    protected BookingMapper getMapper() {
        return BookingMapper.INSTANCE;
    }

    @Override
    protected BookingRepository getRepository() {
        return repository;
    }

    @Override
    protected BookingSpecification getSpecification() {
        return specification;
    }

    @Override
    public BookingResponseDTO save(BookingRequestDTO requestDTO) {
        BookingEntity entity = getMapper().requestDtoToEntity(requestDTO);
        HotelEntity hotelEntity = hotelService.findById(requestDTO.getHotelId());
        for(BookingEntity bookingEntity : hotelEntity.getRooms().get(requestDTO.getRoomId().intValue() -1).getBookings()){
            if(requestDTO.getBookingDate().equals(bookingEntity.getBookingDate())){
                return null;
            }
        }
        entity.setPrice(hotelEntity.getPrice());
        BookingEntity bookingEntitySaved = getRepository().save(entity);
        getRepository().save(bookingEntitySaved);
        return getMapper().entityToResponseDto(bookingEntitySaved);
    }
}
