package com.healthtourism.healthtourism.service;

import com.healthtourism.healthtourism.Specification.HotelInfoSpecification;
import com.healthtourism.healthtourism.database.entities.HotelInfoEntity;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.database.repositories.HotelInfoRepository;
import com.healthtourism.healthtourism.database.repositories.PatientRepository;
import com.healthtourism.healthtourism.mapper.HotelInfoMapper;
import com.healthtourism.healthtourism.model.HotelInfoDTO;
import com.healthtourism.healthtourism.model.RequestDTO.HoteInfoRequestDTO;
import com.healthtourism.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelInfoService extends BaseService<
        HotelInfoEntity,
        HotelInfoDTO,
        HoteInfoRequestDTO,
        HotelInfoMapper,
        HotelInfoRepository,
        HotelInfoSpecification> {
    @Autowired
    HotelInfoMapper hotelInfoMapper;
    @Autowired
    HotelInfoRepository hotelInfoRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    HotelInfoSpecification hotelInfoSpecification;

    @Override
    public HotelInfoMapper getMapper() {
        return hotelInfoMapper;
    }

    @Override
    public HotelInfoRepository getRepository() {
        return hotelInfoRepository;
    }

    @Override
    protected HotelInfoSpecification getSpecification() {return hotelInfoSpecification;}

    public boolean createHotelReservation(String hotelName, String city, UUID patientUuid) {
        if (hotelName == null || city == null || patientUuid == null) {
            return false;
        } else {
            Optional<PatientEntity> patientOptional = patientRepository.findByUuid(patientUuid);

            if (patientOptional.isEmpty()) {
                return false; // Uygun hasta bulunamadıysa işlem başarısız.
            }

            PatientEntity patientEntity = patientOptional.get();

            // Yeni bir HotelInfoEntity oluşturuyoruz
            HotelInfoEntity hotelInfoEntity = new HotelInfoEntity();
            hotelInfoEntity.setHotelName(hotelName);
            hotelInfoEntity.setCity(city);
            hotelInfoEntity.setPatient(patientEntity);
            hotelInfoEntity.setReservationStatus("pending"); // Varsayılan durum "pending" olarak ayarlanabilir
            hotelInfoEntity.setConfirmed(false); // Rezervasyon onay durumu varsayılan olarak "false" olarak ayarlanabilir
            hotelInfoEntity.setInvalid(false); // Rezervasyon geçerlilik durumu varsayılan olarak "false" olarak ayarlanabilir
            hotelInfoEntity.setCreatedAt(LocalDateTime.now());

            // Oluşan otel rezervasyonunu veritabanına kaydediyoruz
            hotelInfoRepository.save(hotelInfoEntity);

            return true;
        }
    }
        public boolean approveHotelReservation(UUID hotelUuid) {
            Optional<HotelInfoEntity> hotelInfoOptional = hotelInfoRepository.findByUuid(hotelUuid);

            if (hotelInfoOptional.isEmpty()) {
                return false; // Belirtilen rezervasyon bulunamazsa işlem başarısız.
            }

            HotelInfoEntity hotelInfoEntity = hotelInfoOptional.get();

            if (!hotelInfoEntity.getReservationStatus().equals("pending")) {
                return false; // Rezervasyon zaten onaylanmışsa işlem başarısız.
            }

            // Rezervasyon durumunu "approved" olarak güncelle
            hotelInfoEntity.setReservationStatus("approved");

            // Rezervasyon onay durumunu "true" olarak güncelle
            hotelInfoEntity.setConfirmed(true);

            // Veritabanına güncellemeleri kaydet
            hotelInfoRepository.save(hotelInfoEntity);

            return true;
        }

    public boolean cancelHotelReservation(UUID hotelUuid) {
        Optional<HotelInfoEntity> hotelInfoOptional = hotelInfoRepository.findByUuid(hotelUuid);

        if (hotelInfoOptional.isEmpty()) {
            return false; // Belirtilen rezervasyon bulunamazsa işlem başarısız.
        }

        HotelInfoEntity hotelInfoEntity = hotelInfoOptional.get();

        if (!hotelInfoEntity.getReservationStatus().equals("approved")) {
            return false; // Rezervasyon onaylanmamışsa iptal edilemez, işlem başarısız.
        }

        // Rezervasyon durumunu "cancelled" olarak güncelle
        hotelInfoEntity.setReservationStatus("cancelled");

        // Veritabanına güncellemeleri kaydet
        hotelInfoRepository.save(hotelInfoEntity);

        return true;
    }


}
