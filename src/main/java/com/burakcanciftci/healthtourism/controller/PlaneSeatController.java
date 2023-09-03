package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.PlaneSeatEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.PlaneSeatRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.PlaneSeatResponseDTO;
import com.burakcanciftci.healthtourism.service.PlaneSeatService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("plane-seat")
@AllArgsConstructor
public class PlaneSeatController extends BaseController<PlaneSeatEntity, PlaneSeatResponseDTO, PlaneSeatRequestDTO> {
    private final PlaneSeatService planeSeatService;

    @Override
    protected PlaneSeatService getService() {
        return this.planeSeatService;
    }
    
    @GetMapping("price/{seatUuid}")
    public ResponseEntity<BigDecimal> getPrice(@PathVariable UUID seatUuid){
        BigDecimal price = planeSeatService.getPrice(seatUuid);

        if(price.compareTo(BigDecimal.ZERO) > 0){
            return new ResponseEntity<>(price, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
