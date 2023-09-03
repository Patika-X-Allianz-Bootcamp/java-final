package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.SeatReservationEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.SeatReservationRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.SeatReservationResponseDTO;
import com.burakcanciftci.healthtourism.service.SeatReservationService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seat-reservation")
@AllArgsConstructor
public class SeatReservationController extends BaseController<SeatReservationEntity, SeatReservationResponseDTO, SeatReservationRequestDTO> {
    private final SeatReservationService seatReservationService;

    @Override
    protected SeatReservationService getService() {
        return this.seatReservationService;
    }

    @PostMapping("reserve")
    public ResponseEntity<SeatReservationResponseDTO> reserveSeat(
            @RequestBody SeatReservationRequestDTO seatReservationRequestDTO){
        SeatReservationResponseDTO seatReservationResponseDTO =
                seatReservationService.reserveSeat(seatReservationRequestDTO);

        if(seatReservationResponseDTO != null){
            return new ResponseEntity<>(seatReservationResponseDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
