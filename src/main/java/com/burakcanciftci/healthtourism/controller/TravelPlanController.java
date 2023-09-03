package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.ExaminationEntity;
import com.burakcanciftci.healthtourism.database.entity.RoomReservationEntity;
import com.burakcanciftci.healthtourism.database.entity.SeatReservationEntity;
import com.burakcanciftci.healthtourism.database.entity.TravelPlanEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.ExaminationRequestDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.TravelPlanRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.ExaminationResponseDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.TravelPlanResponseDTO;
import com.burakcanciftci.healthtourism.service.TravelPlanService;
import com.burakcanciftci.healthtourism.util.BaseController;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("travel-plan")
@AllArgsConstructor
public class TravelPlanController extends BaseController<TravelPlanEntity, TravelPlanResponseDTO, TravelPlanRequestDTO> {
    private final TravelPlanService travelPlanService;

    @Override
    protected TravelPlanService getService() {
        return this.travelPlanService;
    }

    @PostMapping("approve/{uuid}")
    public ResponseEntity<Boolean> reserveSeat(
            @PathVariable UUID uuid){
        Boolean isApproved = travelPlanService.approveTravelPlan(uuid);

        if(isApproved){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
