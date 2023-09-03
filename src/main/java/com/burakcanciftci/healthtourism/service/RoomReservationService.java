package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.HotelRoomEntity;
import com.burakcanciftci.healthtourism.database.entity.RoomReservationEntity;
import com.burakcanciftci.healthtourism.database.repository.CustomerEntityRepository;
import com.burakcanciftci.healthtourism.database.repository.HotelRoomEntityRepository;
import com.burakcanciftci.healthtourism.database.repository.RoomReservationEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.RoomReservationSpecification;
import com.burakcanciftci.healthtourism.mapper.CustomerMapper;
import com.burakcanciftci.healthtourism.mapper.RoomReservationMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.RoomReservationRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.RoomReservationResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoomReservationService extends BaseService<RoomReservationEntity, RoomReservationResponseDTO, RoomReservationRequestDTO> {

    private final RoomReservationEntityRepository roomReservationEntityRepository;
    private final RoomReservationMapper roomReservationMapper;
    private final RoomReservationSpecification roomReservationSpecification;

    private final HotelRoomEntityRepository hotelRoomEntityRepository;
    private final CustomerEntityRepository customerEntityRepository;

    private final TravelPlanService travelPlanService;

    @Override
    protected RoomReservationMapper getMapper() {
        return this.roomReservationMapper;
    }

    @Override
    protected RoomReservationEntityRepository getRepository() {
        return this.roomReservationEntityRepository;
    }

    @Override
    protected RoomReservationSpecification getSpecification() {
        return roomReservationSpecification;
    }

    private List<LocalDate> getDateListInRange(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> datesInRange = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            datesInRange.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return datesInRange;
    }

    @Transactional
    public RoomReservationResponseDTO reserveRoom(RoomReservationRequestDTO roomReservationRequestDTO) {
        Optional<HotelRoomEntity> roomEntityOptional = hotelRoomEntityRepository
                .findByUuid(roomReservationRequestDTO.getRoom().getUuid());

        if (roomEntityOptional.isPresent()) {
            HotelRoomEntity roomEntity = roomEntityOptional.get();

            // Check range between reservation dates if room is available
            List<LocalDate> reservationDateList = getDateListInRange(roomReservationRequestDTO.getStartDate(),
                    roomReservationRequestDTO.getEndDate());

            for(LocalDate date : reservationDateList){
                if(!roomEntity.getAvailableDateList().contains(date)){
                    return null;
                }else{
                    roomEntity.getAvailableDateList().remove(date);
                }
            }

            hotelRoomEntityRepository.save(roomEntity);

            RoomReservationEntity roomReservationEntity = new RoomReservationEntity();
            roomReservationEntity.setRoom(roomEntity);

            if (roomReservationRequestDTO.getCustomer() != null) {
                roomReservationEntity.setCustomer(
                        customerEntityRepository.findByUuid(roomReservationRequestDTO.getCustomer().getUuid()).get());
            }

            roomReservationEntity.setStartDate(roomReservationRequestDTO.getStartDate());
            roomReservationEntity.setEndDate(roomReservationRequestDTO.getEndDate());

            roomReservationEntity.setTotalPrice(
                    HotelRoomService.calculateTotalPrice(
                            roomReservationRequestDTO.getRoom().getPricePerNight(),
                            roomReservationRequestDTO.getRoom().getTotalDayCount()));
            roomReservationEntityRepository.save(roomReservationEntity);

            travelPlanService.addRoomReservationToTravelPlan(
                    roomReservationRequestDTO.getTravelPlanUuid(), roomReservationEntity);

            return roomReservationMapper.entityToDTO(roomReservationEntity);
        }

        return null;
    }
}