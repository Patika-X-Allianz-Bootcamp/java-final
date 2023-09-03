package allianz.healthtourism.service;

import allianz.healthtourism.repository.AppointmentRepository;
import allianz.healthtourism.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReservationCleanupTask {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Scheduled(fixedRate = 60000)
    public void invalidateOldReservations() {
        LocalDateTime now = LocalDateTime.now();

        appointmentRepository.findAll().stream()
                .filter(appointment -> !appointment.isConfirmed() &&
                        appointment.getCreatedAt().plusMinutes(10).isBefore(now))
                .forEach(appointment -> {
                    appointment.setInvalid(true);
                    appointmentRepository.save(appointment);
                });

        hotelRepository.findAll().stream()
                .filter(hotel -> !hotel.isConfirmed() &&
                        hotel.getCreatedAt().plusMinutes(10).isBefore(now))
                .forEach(hotel -> {
                    hotel.setInvalid(true);
                    hotelRepository.save(hotel);
                });
    }
}
