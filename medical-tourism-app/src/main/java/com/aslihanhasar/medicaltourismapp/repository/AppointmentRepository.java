package com.aslihanhasar.medicaltourismapp.repository;

import com.aslihanhasar.medicaltourismapp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByAppointmentNumber(String appointmentNumber);

    List<Appointment> findByDoctor_Specialization_Name(String specialization);

    /*
    @Query("SELECT COUNT(a) = 0 FROM Appointment a " +
            "WHERE a.doctor.id = :doctorId " +
            "AND a.appointmentDate = :appointmentDate " +
            "AND a.appointmentTime = :appointmentTime")
    boolean isDoctorAvailable(
            @Param("doctorId") Long doctorId,
            @Param("appointmentDate") LocalDate appointmentDate,
            @Param("appointmentTime") LocalTime appointmentTime
    );

     */
/*
    @Query("SELECT COUNT(a) = 0 FROM Appointment a " +
            "WHERE a.patient.id = :patientId " +
            "AND a.appointmentDate = :appointmentDate " +
            "AND a.appointmentTime = :appointmentTime")
    boolean isPatientAvailable(
            @Param("patientId") Long patientId,
            @Param("appointmentDate") LocalDate appointmentDate,
            @Param("appointmentTime") LocalTime appointmentTime
    );

 */
}
