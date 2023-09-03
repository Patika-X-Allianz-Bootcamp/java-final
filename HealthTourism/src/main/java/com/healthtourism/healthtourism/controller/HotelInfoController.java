package com.healthtourism.healthtourism.controller;

import com.healthtourism.healthtourism.Specification.HotelInfoSpecification;
import com.healthtourism.healthtourism.database.entities.HotelInfoEntity;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.database.repositories.HotelInfoRepository;
import com.healthtourism.healthtourism.mapper.HotelInfoMapper;
import com.healthtourism.healthtourism.model.HotelInfoDTO;
import com.healthtourism.healthtourism.model.RequestDTO.HealthServiceRequestDTO;
import com.healthtourism.healthtourism.model.RequestDTO.HoteInfoRequestDTO;
import com.healthtourism.healthtourism.service.HotelInfoService;
import com.healthtourism.healthtourism.util.BaseController;
import com.healthtourism.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/hotelInfo")
public class HotelInfoController extends BaseController<HotelInfoEntity,
        HotelInfoDTO,
        HoteInfoRequestDTO,
        HotelInfoMapper,
        HotelInfoRepository,
        HotelInfoService,
        HotelInfoSpecification> {
    @Autowired
    HotelInfoService hotelInfoService;


    @Override
    protected HotelInfoService getService() {
        return hotelInfoService;
    }

    @PostMapping("/create-hotel-reservation")
    public ResponseEntity<String> createHotelReservation(@RequestBody HoteInfoRequestDTO reservationRequestDTO) {
        try {
            boolean isCreated = hotelInfoService.createHotelReservation(
                    reservationRequestDTO.getHotelName(),
                    reservationRequestDTO.getCity(),
                    reservationRequestDTO.getPatientUuid()
            );

            if (isCreated) {
                return ResponseEntity.ok("Hotel reservation created successfully.");
            } else {
                return ResponseEntity.badRequest().body("Failed to create hotel reservation.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid input.");
        }
    }

    @PostMapping("/approve-reservation/{hotelUuid}")
    public ResponseEntity<String> approveReservation(@RequestParam UUID hotelUuid) {
        boolean result = hotelInfoService.approveHotelReservation(hotelUuid);

        if (result) {
            return ResponseEntity.ok("Rezervasyon onaylandı.");
        } else {
            return ResponseEntity.badRequest().body("Rezervasyon onaylanamadı.");
        }
    }

    @PostMapping("/cancel/{hotelUuid}")
    public ResponseEntity<String> cancelHotelReservation(@PathVariable UUID hotelUuid) {
        boolean result = hotelInfoService.cancelHotelReservation(hotelUuid);
        if (result) {
            return new ResponseEntity<>("Hotel reservation is cancelled.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Hotel reservation cannot be cancelled.", HttpStatus.BAD_REQUEST);
        }
    }
}
