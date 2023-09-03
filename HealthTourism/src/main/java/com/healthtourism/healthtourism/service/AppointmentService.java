package com.healthtourism.healthtourism.service;

import com.healthtourism.healthtourism.Specification.AppointmentSpecification;
import com.healthtourism.healthtourism.database.entities.*;
import com.healthtourism.healthtourism.database.repositories.*;
import com.healthtourism.healthtourism.mapper.AppointmentMapper;
import com.healthtourism.healthtourism.mapper.DoctorMapper;
import com.healthtourism.healthtourism.mapper.PatientMapper;
import com.healthtourism.healthtourism.model.AppointmentDTO;
import com.healthtourism.healthtourism.model.DoctorDTO;
import com.healthtourism.healthtourism.model.PatientDTO;
import com.healthtourism.healthtourism.model.RequestDTO.AppointmentRequestDTO;
import com.healthtourism.healthtourism.util.BaseService;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.healthtourism.healthtourism.database.entities.AppointmentHoursEnum;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService extends BaseService<
        AppointmentEntity,
        AppointmentDTO,
        AppointmentRequestDTO,
        AppointmentMapper,
        AppointmentRepository,
        AppointmentSpecification> {
    @Autowired
    AppointmentMapper appointmentMapper;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    PatientService patientService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    AppointmentSpecification appointmentSpecification;

    @Override
    public AppointmentMapper getMapper() {
        return appointmentMapper;
    }

    @Override
    public AppointmentRepository getRepository() {
        return appointmentRepository;
    }

    @Override
    protected AppointmentSpecification getSpecification() {return appointmentSpecification;}

    public AppointmentService(AppointmentRepository appointmentRepository, DoctorService doctorService) {
        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
    }

    public boolean createAppointment(LocalDate appointmentDate, String appointmentTime, UUID patientUuid, UUID doctorUuid) {
        if (appointmentDate == null || appointmentTime == null || patientUuid == null || doctorUuid == null) {
            return false;
        } else {
            Optional<PatientEntity> patientOptional = patientRepository.findByUuid(patientUuid);
            Optional<DoctorEntity> doctorOptional = doctorRepository.findByUuid(doctorUuid);

            if (patientOptional.isEmpty() || doctorOptional.isEmpty()) {
                return false; // Uygun hasta veya doktor bulunamadıysa işlem başarısız.
            }

            PatientEntity patientEntity = patientOptional.get();
            DoctorEntity doctorEntity = doctorOptional.get();

            // Aynı tarih-saat ve doktordan başka randevu var mı kontrolü
            boolean isAppointmentAvailable = appointmentRepository.existsByDoctorAndAppointmentDateAndAppointmentTime(doctorEntity, appointmentDate, appointmentTime);
            if (isAppointmentAvailable) {
                return false; // Aynı tarih-saat ve doktordan başka randevu zaten var.
            }

            // Yeni bir AppointmentEntity oluşturuyoruz
            AppointmentEntity appointmentEntity = new AppointmentEntity();
            appointmentEntity.setAppointmentDate(appointmentDate);
            appointmentEntity.setAppointmentTime(appointmentTime);
            appointmentEntity.setPatient(patientEntity);
            appointmentEntity.setDoctor(doctorEntity);
            appointmentEntity.setStatus("pending");

            // Oluşan randevuyu veritabanına kaydediyoruz
            appointmentRepository.save(appointmentEntity);

            // Oluşan randevuyu AppointmentDTO'ya dönüştürerek döndürüyoruz
            return true;
        }
    }

    public boolean approveAppointment(UUID appointmentUuid) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findByUuid(appointmentUuid);

        if (appointmentOptional.isPresent()) {
            AppointmentEntity appointment = appointmentOptional.get();
            if ("pending".equals(appointment.getStatus())) {
                // Durumu "approved" olarak güncelle
                appointment.setStatus("approved");
                appointmentRepository.save(appointment);
                return true;
            }
        }
        return false; // Randevu bulunamadı veya durumu uygun değil
    }


    // ...

    @Scheduled(fixedRate = 60000) // 1 dakika (60 saniye) aralıklarla çalışacak
    public void checkPendingAppointments() {
        List<AppointmentEntity> pendingAppointments = appointmentRepository.findByStatus("pending");

        for (AppointmentEntity appointment : pendingAppointments) {
            LocalDateTime creationTime = appointment.getDateAndTime();
            LocalDateTime currentTime = LocalDateTime.now();
            Duration timeSinceCreation = Duration.between(creationTime, currentTime);

            if (timeSinceCreation.toMinutes() > 10) {
                appointment.setStatus("overtimecancelation");
                appointmentRepository.save(appointment);
            }
        }
    }


    public boolean cancelAppointment(UUID appointmentUuid) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findByUuid(appointmentUuid);

        if (appointmentOptional.isPresent()) {
            AppointmentEntity appointment = appointmentOptional.get();

            // Onaylanmış randevuyu iptal edemezsiniz
            if ("APPROVED".equals(appointment.getStatus())) {
                return false;
            }

            appointmentRepository.delete(appointment);
            return true;
        }

        return false;
    }
}
