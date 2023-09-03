package com.patika.healthtourism.controller;

import com.patika.healthtourism.database.entity.TravelPlanEntity;
import com.patika.healthtourism.database.repository.TravelPlanEntityRepository;
import com.patika.healthtourism.mapper.TravelPlanMapper;
import com.patika.healthtourism.model.FlightDTO;
import com.patika.healthtourism.model.HotelDTO;
import com.patika.healthtourism.model.PatientDTO;
import com.patika.healthtourism.model.TravelPlanDTO;
import com.patika.healthtourism.model.requestDTO.TravelPlanRequestDTO;
import com.patika.healthtourism.service.FlightService;
import com.patika.healthtourism.service.HotelService;
import com.patika.healthtourism.service.PatientService;
import com.patika.healthtourism.service.TravelPlanService;
import com.patika.healthtourism.util.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/travelPlan")
public class TravelPlanController extends BaseController<TravelPlanEntity, TravelPlanDTO, TravelPlanRequestDTO,
        TravelPlanMapper, TravelPlanEntityRepository, TravelPlanService> {
    private final TravelPlanService travelPlanService;

    private final PatientService patientService;

    private final HotelService hotelService;

    private final FlightService flightService;

    public TravelPlanController(TravelPlanService travelPlanService, PatientService patientService, HotelService hotelService, FlightService flightService) {
        this.travelPlanService = travelPlanService;
        this.patientService = patientService;
        this.hotelService = hotelService;
        this.flightService = flightService;
    }
    private PatientDTO selectedPatient;
    private LocalDateTime selectedAppointmentDate;

    @Override
    protected TravelPlanService getService() {
        return travelPlanService;
    }



    @PostMapping("/select-patient")
    public ResponseEntity<String> selectPatient(@RequestParam UUID patientUuid) {
        selectedPatient = patientService.getByUUID(patientUuid);
        return ResponseEntity.ok("Patient selected successfully");
    }

    @PostMapping("/select-appointment-date")
    public ResponseEntity<String> selectAppointmentDate(@RequestParam String appointmentDate) {
        selectedAppointmentDate = LocalDateTime.parse(appointmentDate);
        return ResponseEntity.ok("Appointment date selected successfully");
    }
    @GetMapping("/select-hotel")
    public ResponseEntity<List<HotelDTO>> selectHotel() {
        List<HotelDTO> availableHotels = hotelService.getAvailableHotels(selectedAppointmentDate);
        return ResponseEntity.ok(availableHotels);
    }

    @GetMapping("/select-flight")
    public ResponseEntity<List<FlightDTO>> selectFlight() {
        List<FlightDTO> availableFlights = flightService.getAvailableFlights(selectedAppointmentDate);
        return ResponseEntity.ok(availableFlights);
    }

    @PostMapping("/create-travel-plan")
    public ResponseEntity<String> createTravelPlan(@RequestBody TravelPlanRequestDTO request) {
        TravelPlanDTO travelPlan = new TravelPlanDTO();
        travelPlan.setPatient(selectedPatient);
        travelPlan.setHotel(hotelService.getByUUID(request.getHotel().getUuid()));
        travelPlan.setFlight(flightService.getByUUID(request.getFlight().getUuid()));
        travelPlan.setReservationDateTime(request.getReservationDateTime());

        travelPlanService.createTravelPlan(travelPlan);

        return ResponseEntity.ok("Travel plan created successfully");
    }
}
