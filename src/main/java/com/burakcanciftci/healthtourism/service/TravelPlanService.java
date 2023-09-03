package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.ExaminationEntity;
import com.burakcanciftci.healthtourism.database.entity.RoomReservationEntity;
import com.burakcanciftci.healthtourism.database.entity.SeatReservationEntity;
import com.burakcanciftci.healthtourism.database.entity.TravelPlanEntity;
import com.burakcanciftci.healthtourism.database.repository.ExaminationEntityRepository;
import com.burakcanciftci.healthtourism.database.repository.RoomReservationEntityRepository;
import com.burakcanciftci.healthtourism.database.repository.SeatReservationEntityRepository;
import com.burakcanciftci.healthtourism.database.repository.TravelPlanEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.TravelPlanSpecification;
import com.burakcanciftci.healthtourism.mapper.TravelPlanMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.TravelPlanRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.TravelPlanResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TravelPlanService extends BaseService<TravelPlanEntity, TravelPlanResponseDTO, TravelPlanRequestDTO> {

    private final TravelPlanEntityRepository travelPlanEntityRepository;
    private final TravelPlanMapper travelPlanMapper;
    private final TravelPlanSpecification travelPlanSpecification;

    private final BankAccountService bankAccountService;

    private final TaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
    private final RoomReservationEntityRepository roomReservationEntityRepository;
    private final ExaminationEntityRepository examinationEntityRepository;
    private final SeatReservationEntityRepository seatReservationEntityRepository;

    @Override
    protected TravelPlanMapper getMapper() {
        return this.travelPlanMapper;
    }

    @Override
    protected TravelPlanEntityRepository getRepository() {
        return this.travelPlanEntityRepository;
    }

    @Override
    protected TravelPlanSpecification getSpecification() {
        return travelPlanSpecification;
    }
    
    public void addExaminationToTravelPlan(@NotNull ExaminationEntity examinationEntity){
        TravelPlanEntity travelPlanEntity = new TravelPlanEntity();

        if(examinationEntity.getCustomer() != null){
            travelPlanEntity.setCustomer(examinationEntity.getCustomer());
        }

        travelPlanEntity.setExamination(examinationEntity);
        
        travelPlanEntityRepository.save(travelPlanEntity);

        // To check if reservations are not set after 10 minutes
        Runnable reservationCheckTask = new Runnable() {
            @Override
            public void run() {
                checkReservations(travelPlanEntity.getUuid());
            }
        };

        taskScheduler.schedule(reservationCheckTask, Instant.now().plus(Duration.ofMinutes(10)));
    }

    public void addRoomReservationToTravelPlan(UUID travelPlanUuid,
                                               @NotNull RoomReservationEntity roomReservationEntity){
        TravelPlanEntity travelPlanEntity = travelPlanEntityRepository.findByUuid(travelPlanUuid).orElse(null);
        if(travelPlanEntity == null){
            return;
        }

        travelPlanEntity.setRoomReservation(roomReservationEntity);
        travelPlanEntityRepository.save(travelPlanEntity);
    }

    public void addSeatReservationToTravelPlan(UUID travelPlanUuid,
                                               @NotNull SeatReservationEntity seatReservationEntity){
        TravelPlanEntity travelPlanEntity = travelPlanEntityRepository.findByUuid(travelPlanUuid).orElse(null);
        if(travelPlanEntity == null){
            return;
        }

        travelPlanEntity.setSeatReservation(seatReservationEntity);
        travelPlanEntityRepository.save(travelPlanEntity);
    }

    public Boolean approveTravelPlan(UUID uuid){
        TravelPlanEntity travelPlanEntity = travelPlanEntityRepository.findByUuid(uuid).orElse(null);
        if(travelPlanEntity == null){
            return true;
        }

        bankAccountService.addMoneyToBankAccount(
                travelPlanEntity.getRoomReservation().getRoom().getHotel().getBankAccountSet(),
                travelPlanEntity.getRoomReservation().getTotalPrice());

        bankAccountService.addMoneyToBankAccount(
                travelPlanEntity.getSeatReservation().getFlight().getAirportFrom().getBankAccountSet(),
                travelPlanEntity.getSeatReservation().getSeat().getTicketPrice()
        );

        return false;
    }

    private void checkReservations(UUID travelPlanUuid){
        TravelPlanEntity travelPlanEntity = travelPlanEntityRepository.findByUuid(travelPlanUuid).orElse(null);

        if(travelPlanEntity == null){
            return;
        }

        if(travelPlanEntity.getRoomReservation() == null
                || travelPlanEntity.getSeatReservation() == null
                || travelPlanEntity.getExamination() == null){

            if(travelPlanEntity.getRoomReservation() != null){
                roomReservationEntityRepository.delete(travelPlanEntity.getRoomReservation());
            }

            if(travelPlanEntity.getSeatReservation() != null){
                seatReservationEntityRepository.delete(travelPlanEntity.getSeatReservation());
            }

            if(travelPlanEntity.getExamination() != null){
                examinationEntityRepository.delete(travelPlanEntity.getExamination());
            }

            travelPlanEntityRepository.delete(travelPlanEntity);
        }
    }
}