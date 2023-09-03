package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.RoomReservationEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.RoomReservationRequestDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.SeatReservationRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.RoomReservationResponseDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.SeatReservationResponseDTO;
import com.burakcanciftci.healthtourism.service.RoomReservationService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room-reservation")
@AllArgsConstructor
public class RoomReservationController extends BaseController<RoomReservationEntity, RoomReservationResponseDTO, RoomReservationRequestDTO> {
    private final RoomReservationService roomReservationService;

    @Override
    protected RoomReservationService getService() {
        return this.roomReservationService;
    }

    @PostMapping("reserve")
    public ResponseEntity<RoomReservationResponseDTO> reserveRoom(
            @RequestBody RoomReservationRequestDTO roomReservationRequestDTO){
        RoomReservationResponseDTO roomReservationResponseDTO =
                roomReservationService.reserveRoom(roomReservationRequestDTO);

        if(roomReservationResponseDTO != null){
            return new ResponseEntity<>(roomReservationResponseDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}