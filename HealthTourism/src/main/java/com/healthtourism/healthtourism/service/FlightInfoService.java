package com.healthtourism.healthtourism.service;
import com.healthtourism.healthtourism.Specification.FlightInfoSpecification;
import com.healthtourism.healthtourism.database.entities.FlightInfoEntity;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.database.repositories.FlightInfoRepository;
import com.healthtourism.healthtourism.database.repositories.PatientRepository;
import com.healthtourism.healthtourism.mapper.FlightInfoMapper;
import com.healthtourism.healthtourism.model.FlightInfoDTO;
import com.healthtourism.healthtourism.model.RequestDTO.FlightInfoRequestDTO;
import com.healthtourism.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlightInfoService extends BaseService<FlightInfoEntity,
        FlightInfoDTO,
        FlightInfoRequestDTO,
        FlightInfoMapper,
        FlightInfoRepository,
        FlightInfoSpecification> {
    @Autowired
    FlightInfoMapper flightInfoMapper;
    @Autowired
    FlightInfoRepository flightInfoRepository;
    @Autowired
    FlightInfoSpecification flightInfoSpecification;
    @Autowired
    PatientRepository patientRepository;

    @Override
    public FlightInfoMapper getMapper() {
        return flightInfoMapper;
    }

    @Override
    public FlightInfoRepository getRepository() {
        return flightInfoRepository;
    }

    @Override
    protected FlightInfoSpecification getSpecification() {
        return flightInfoSpecification;
    }

    public boolean createFlight(String airlineCompany, String flightNumber, String arrivalCity, String departureCity, LocalDateTime arrivalDateTime, LocalDateTime departureDateTime, List<UUID> patientUuids) {
        if (airlineCompany == null || flightNumber == null || arrivalCity == null || departureCity == null || arrivalDateTime == null || departureDateTime == null) {
            return false;
        } else {
            FlightInfoEntity flightInfoEntity = new FlightInfoEntity();
            flightInfoEntity.setAirlineCompany(airlineCompany);
            flightInfoEntity.setFlightNumber(flightNumber);
            flightInfoEntity.setArrivalCity(arrivalCity);
            flightInfoEntity.setDepartureCity(departureCity);
            flightInfoEntity.setArrivalDateTime(arrivalDateTime);
            flightInfoEntity.setDepartureDateTime(departureDateTime);
            flightInfoEntity.setReservationStatus("pending");
            flightInfoEntity.setCurrentDateTime(LocalDateTime.now());

            // Hasta UUID'lerini alarak hasta nesnelerini getirin ve uçuşa ekleyin
            List<PatientEntity> patientsToAdd = new ArrayList<>();
            for (UUID patientUuid : patientUuids) {
                Optional<PatientEntity> patientEntityOptional = patientRepository.findByUuid(patientUuid);

                if (patientEntityOptional.isPresent()) {
                    PatientEntity patientEntity = patientEntityOptional.get();
                    patientsToAdd.add(patientEntity);
                }
            }

            flightInfoEntity.setPatients(patientsToAdd);

            flightInfoRepository.save(flightInfoEntity);
            return true;
        }

    }

    public List<FlightInfoDTO> getAllFlights() {
        List<FlightInfoEntity> allFlights = flightInfoRepository.findAll();

        List<FlightInfoDTO> allFlightDTOs = new ArrayList<>();
        for (FlightInfoEntity flightEntity : allFlights) {
            FlightInfoDTO flightDTO = flightInfoMapper.entityToDTO(flightEntity);
            allFlightDTOs.add(flightDTO);
        }

        return allFlightDTOs;
    }

    // Hasta randevu oluştururken bu metodu kullanabilir

    // Hasta uçuş rezervasyonu yapar ve reservationStatus'u "reserved" yapar
    public FlightInfoDTO makeReservation(UUID flightUuid, UUID patientUuid) {
        Optional<FlightInfoEntity> flightEntityOptional = getRepository().findByUuid(flightUuid);
        Optional<PatientEntity> patientEntityOptional = patientRepository.findByUuid(patientUuid);

        if (flightEntityOptional.isPresent() && patientEntityOptional.isPresent()) {
            FlightInfoEntity flightEntity = flightEntityOptional.get();
            PatientEntity patientEntity = patientEntityOptional.get();

            // Eğer uçuş henüz rezerve edilmemişse
            if (!flightEntity.getReservationStatus().equals("pending")) {
                flightEntity.setReservationStatus("reserved"); // reservationStatus'u "reserved" olarak ayarla
                getRepository().save(flightEntity);
                return getMapper().entityToDTO(flightEntity);
            }
        }

        return null; // Uçuş veya hasta bulunamadı veya uçuş zaten rezerve edilmiş
    }


    // Hasta bir uçuşa atama işlemi


    // 10 dakika içinde kesinleşmeyen rezervasyonları kontrol et ve geçersiz say
    @Scheduled(fixedRate = 10 * 60 * 1000) // 10 dakika
    public void invalidateUnconfirmedReservations() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<FlightInfoEntity> unconfirmedReservations = getRepository().findByReservationStatusAndCurrentDateTimeBefore("reserved", currentDateTime.minusMinutes(10));

        for (FlightInfoEntity reservation : unconfirmedReservations) {
            reservation.setReservationStatus("overtime");
            getRepository().save(reservation);
        }
    }


    // Uçuş rezervasyonunu onayla
    public boolean approveReservation(UUID flightUuid) {
        Optional<FlightInfoEntity> flightEntityOptional = getRepository().findByUuid(flightUuid);

        if (flightEntityOptional.isPresent()) {
            FlightInfoEntity flightEntity = flightEntityOptional.get();
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime creationTime = flightEntity.getCurrentDateTime();

            System.out.println("Current Time: " + currentTime);
            System.out.println("Creation Time: " + creationTime);

            if (flightEntity.getReservationStatus().equals("pending")) {
                if (creationTime.plusMinutes(10).isBefore(currentTime)) {
                    System.out.println("Reservation is overtime.");
                    flightEntity.setReservationStatus("overtime");
                    flightEntity.setConfirmed(false);
                    getRepository().save(flightEntity);
                    return true;
                } else {
                    System.out.println("Reservation is approved.");
                    flightEntity.setReservationStatus("approved");
                    flightEntity.setConfirmed(true);
                    getRepository().save(flightEntity);
                    return true;
                }
            }
        } else {
            System.out.println("Flight not found with UUID: " + flightUuid);
        }

        return false;
    }


}
