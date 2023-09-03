package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.FlightEntity;
import com.burakcanciftci.healthtourism.database.entity.PlaneSeatEntity;
import com.burakcanciftci.healthtourism.database.entity.SeatReservationEntity;
import com.burakcanciftci.healthtourism.database.repository.CustomerEntityRepository;
import com.burakcanciftci.healthtourism.database.repository.FlightEntityRepository;
import com.burakcanciftci.healthtourism.database.repository.PlaneSeatEntityRepository;
import com.burakcanciftci.healthtourism.database.repository.SeatReservationEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.SeatReservationSpecification;
import com.burakcanciftci.healthtourism.mapper.CustomerMapper;
import com.burakcanciftci.healthtourism.mapper.FlightMapper;
import com.burakcanciftci.healthtourism.mapper.SeatReservationMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.SeatReservationRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.SeatReservationResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class SeatReservationService extends BaseService<SeatReservationEntity, SeatReservationResponseDTO, SeatReservationRequestDTO> {

    private final SeatReservationEntityRepository seatReservationEntityRepository;
    private final SeatReservationMapper seatReservationMapper;
    private final SeatReservationSpecification seatReservationSpecification;

    private final PlaneSeatEntityRepository planeSeatEntityRepository;
    private final FlightEntityRepository flightEntityRepository;
    private final CustomerEntityRepository customerEntityRepository;

    private final TravelPlanService travelPlanService;

    @Override
    protected SeatReservationMapper getMapper() {
        return this.seatReservationMapper;
    }

    @Override
    protected SeatReservationEntityRepository getRepository() {
        return this.seatReservationEntityRepository;
    }

    @Override
    protected SeatReservationSpecification getSpecification() {
        return seatReservationSpecification;
    }

    public SeatReservationResponseDTO reserveSeat(SeatReservationRequestDTO seatReservationRequestDTO) {
        Optional<PlaneSeatEntity> planeSeatEntityOptional
                = planeSeatEntityRepository.findByUuid(seatReservationRequestDTO.getSeat().getUuid());

        if (planeSeatEntityOptional.isPresent()) {

            // Check if seat is already reserved
            Optional<SeatReservationEntity> seatReservationEntityOptional
                    = seatReservationEntityRepository.findByCode(
                    SeatReservationEntity.generateCode(
                            seatReservationRequestDTO.getSeat().getSeatCode(),
                            seatReservationRequestDTO.getFlight().getFlightCode()));

            if (seatReservationEntityOptional.isEmpty()) {

                SeatReservationEntity seatReservationEntity = new SeatReservationEntity();
                seatReservationEntity.setSeat(planeSeatEntityOptional.get());

                seatReservationEntity.setFlight(
                        flightEntityRepository.findByUuid(
                                seatReservationRequestDTO.getFlight().getUuid()).orElse(null));

                if(seatReservationRequestDTO.getCustomer() != null){
                    seatReservationEntity.setCustomer(
                            customerEntityRepository.findByUuid(
                                    seatReservationRequestDTO.getCustomer().getUuid()).orElse(null));
                }

                seatReservationEntity.setCode(SeatReservationEntity.generateCode(
                        seatReservationEntity.getSeat().getSeatCode(),
                        seatReservationEntity.getFlight().getFlightCode()));

                seatReservationEntityRepository.save(seatReservationEntity);

                travelPlanService.addSeatReservationToTravelPlan(
                        seatReservationRequestDTO.getTravelPlanUuid(), seatReservationEntity);

                return seatReservationMapper.entityToDTO(seatReservationEntity);
            }
        }

        return null;
    }
}