package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.TravelPlanEntity;
import com.allianz.healthtourismagency.database.repository.TravelPlanRepository;
import com.allianz.healthtourismagency.database.specification.TravelPlanSpecification;
import com.allianz.healthtourismagency.mapper.TravelPlanMapper;
import com.allianz.healthtourismagency.model.DoctorDTO;
import com.allianz.healthtourismagency.model.PatientDTO;
import com.allianz.healthtourismagency.model.TravelPlanDTO;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.HotelReservationRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.TravelPlanRequestDTO;
import com.allianz.healthtourismagency.service.TravelPlanService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("travel_plan")
public class TravelPlanController extends BaseController<
        TravelPlanEntity, TravelPlanDTO, TravelPlanRequestDTO, TravelPlanMapper,
        TravelPlanRepository, TravelPlanSpecification,
        TravelPlanService> {

    private final TravelPlanService travelPlanService;

    public TravelPlanController(TravelPlanService travelPlanService) {
        this.travelPlanService = travelPlanService;
    }

    @Override
    protected TravelPlanService getService() {
        return travelPlanService;
    }

    @PutMapping("add-flight-to-travel-plan/{travelPlanUUID}/flight/{flightUUID}")
    public ResponseEntity<TravelPlanDTO> addFlightToTravelPlan(@PathVariable UUID travelPlanUUID, @PathVariable UUID flightUUID) {
        if (getService().addFlightToTravelPlan(travelPlanUUID, flightUUID) != null) {
            return new ResponseEntity<>(getService().addFlightToTravelPlan(travelPlanUUID, flightUUID), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("add-hotel-to-travel-plan/{travelPlanUUID}/hotel/{hotelUUID}")
    public ResponseEntity<TravelPlanDTO> addHotelToTravelPlan(@PathVariable UUID travelPlanUUID,
                                                              @PathVariable UUID hotelUUID,
                                                              @RequestBody HotelReservationRequestDTO hotelReservationRequestDTO) {
        if (getService().addHotelToTravelPlan(travelPlanUUID, hotelUUID, hotelReservationRequestDTO) != null) {
            return new ResponseEntity<>(getService().addHotelToTravelPlan(travelPlanUUID, hotelUUID, hotelReservationRequestDTO),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
