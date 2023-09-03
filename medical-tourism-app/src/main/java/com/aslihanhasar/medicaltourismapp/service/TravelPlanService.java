package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.AppointmentPlanRequest;
import com.aslihanhasar.medicaltourismapp.dto.request.HotelPlanRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.AppointmentPlanResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.HotelPlanResponse;
import com.aslihanhasar.medicaltourismapp.entity.Appointment;
import com.aslihanhasar.medicaltourismapp.entity.Hotel;
import com.aslihanhasar.medicaltourismapp.entity.Patient;
import com.aslihanhasar.medicaltourismapp.entity.TravelPlan;
import com.aslihanhasar.medicaltourismapp.enums.AppointmentStatus;
import com.aslihanhasar.medicaltourismapp.enums.HotelStatus;
import com.aslihanhasar.medicaltourismapp.exception.AppointmentValidationException;
import com.aslihanhasar.medicaltourismapp.exception.HotelValidationException;
import com.aslihanhasar.medicaltourismapp.repository.TravelPlanRepository;
import com.aslihanhasar.medicaltourismapp.utils.UniqueNumberGeneratorUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Service class responsible for managing travel plans, including appointment and hotel plans.
 */
@Service
@RequiredArgsConstructor
public class TravelPlanService {
    private final TravelPlanRepository planRepository;
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    private final HotelService hotelService;
    private final CityService cityService;

    /**
     * Saves an appointment plan based on the provided request and schedules appointment confirmation.
     *
     * @param request The request containing appointment plan details.
     * @return A response containing information about the saved appointment plan.
     */
    @Transactional
    public AppointmentPlanResponse saveAppointmentPlan(AppointmentPlanRequest request) {
        validateAppointmentPlanRequest(request);
        TravelPlan travelPlan = buildAppointmentPlanAndSave(request);
        appointmentService.scheduleAppointmentConfirmation(travelPlan.getAppointment());
        return convertAppointmentPlanToResponse(travelPlan);
    }

    /**
     * Confirms an appointment plan based on appointment and patient numbers.
     *
     * @param appointmentNumber The unique appointment number.
     * @param patientNumber     The unique patient number.
     */
    public void confirmAppointmentPlan(String appointmentNumber, String patientNumber) {
        appointmentService.confirmAppointment(appointmentNumber, patientNumber);
    }

    /**
     * Saves a hotel plan based on the provided request and schedules hotel confirmation.
     *
     * @param request The request containing hotel plan details.
     * @return A response containing information about the saved hotel plan.
     */
    @Transactional
    public HotelPlanResponse saveHotelPlan(HotelPlanRequest request) {
        validateHotelPlanRequest(request);
        TravelPlan travelPlan = buildHotelPlanAndSave(request);
        hotelService.scheduleHotelConfirmation(travelPlan.getHotel(), request.getPersonCount());
        return convertHotelPlanToResponse(travelPlan);
    }

    /**
     * Confirms a hotel plan based on the reservation number.
     *
     * @param reservationNumber The unique hotel reservation number.
     */
    public void confirmHotelPlan(String reservationNumber) {
        hotelService.confirmHotelReservation(reservationNumber);
    }

    private TravelPlan buildAppointmentPlanAndSave(AppointmentPlanRequest request) {
        Patient patientByNumber = patientService.getByPatientNumber(request.getPatientNumber());
        Appointment appointmentById = appointmentService.getAppointmentById(request.getAppointmentId());
        appointmentService.checkPatientAvailability(patientByNumber, appointmentById);
        String uniqueAppointmentNumber = appointmentService.generateUniqueAppointmentNumber();
        appointmentById.setAppointmentNumber(uniqueAppointmentNumber);
        appointmentById.setAppointmentStatus(AppointmentStatus.PENDING);
        TravelPlan travelPlan = TravelPlan.builder()
                .appointment(appointmentById)
                .patient(patientByNumber)
                .build();
        return planRepository.save(travelPlan);
    }

    private TravelPlan buildHotelPlanAndSave(HotelPlanRequest request) {
        Patient patientByNumber = patientService.getByPatientNumber(request.getPatientNumber());
        Hotel hotelById = hotelService.getHotelById(request.getHotelId());
        hotelService.reserveRoom(hotelById, request.getPersonCount());
        hotelById.setHotelStatus(HotelStatus.RESERVED);
        String reservationNumber = UniqueNumberGeneratorUtils.generateUniqueNumber();
        hotelById.setReservationNumber(reservationNumber);
        TravelPlan travelPlan = TravelPlan.builder()
                .hotel(hotelById)
                .patient(patientByNumber)
                .build();
        return planRepository.save(travelPlan);
    }

    private AppointmentPlanResponse convertAppointmentPlanToResponse(TravelPlan travelPlan) {
        return AppointmentPlanResponse.builder()
                .patient(patientService.convertPatientToResponse(travelPlan.getPatient()))
                .appointment(appointmentService.convertAppointmentToResponse(travelPlan.getAppointment()))
                .appointmentStatus(travelPlan.getAppointment().getAppointmentStatus())
                .build();
    }

    private HotelPlanResponse convertHotelPlanToResponse(TravelPlan travelPlan) {
        return HotelPlanResponse.builder()
                .patient(patientService.convertPatientToResponse(travelPlan.getPatient()))
                .hotelId(travelPlan.getHotel().getId())
                .hotel(travelPlan.getHotel().getName() + " - " + travelPlan.getHotel().getHotelCode())
                .city(cityService.convertCityToResponse(travelPlan.getHotel().getCity()))
                .build();
    }


    private void validateAppointmentPlanRequest(AppointmentPlanRequest request) {
        boolean anyFieldBlank = Stream.of(request.getPatientNumber(),
                        request.getAppointmentId())
                .anyMatch(value -> value == null || value.toString().trim().isEmpty());
        if (anyFieldBlank) {
            throw new AppointmentValidationException("Required fields cannot be left blank");
        }
    }

    private void validateHotelPlanRequest(HotelPlanRequest request) {
        boolean anyFieldBlank = Stream.of(request.getHotelId(),
                        request.getPatientNumber(),
                        request.getPersonCount())
                .anyMatch(value -> value == null || value.toString().trim().isEmpty());
        if (anyFieldBlank) {
            throw new HotelValidationException("Required fields cannot be left blank");
        }
    }

}
