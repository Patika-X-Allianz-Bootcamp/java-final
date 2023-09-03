package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.AppointmentSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.AppointmentSaveResponse;
import com.aslihanhasar.medicaltourismapp.entity.Appointment;
import com.aslihanhasar.medicaltourismapp.entity.Doctor;
import com.aslihanhasar.medicaltourismapp.entity.Patient;
import com.aslihanhasar.medicaltourismapp.enums.AppointmentStatus;
import com.aslihanhasar.medicaltourismapp.exception.*;
import com.aslihanhasar.medicaltourismapp.repository.AppointmentRepository;
import com.aslihanhasar.medicaltourismapp.utils.DateUtils;
import com.aslihanhasar.medicaltourismapp.utils.UniqueNumberGeneratorUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

/**
 * Service class responsible for managing appointments, including creation, confirmation,
 * and retrieval of appointments.
 */
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;

    /**
     * Creates a new appointment based on the provided request and saves it to the database.
     * Also associates the appointment with the corresponding doctor.
     *
     * @param request The request containing appointment details.
     * @return A response containing information about the created appointment.
     */
    @Transactional
    public AppointmentSaveResponse save(AppointmentSaveRequest request) {
        validateAppointmentSaveRequest(request);
        Appointment appointment = buildAppointmentAndSave(request);
        doctorService.addAppointmentToDoctor(appointment.getDoctor(), appointment);
        return convertAppointmentToResponse(appointment);
    }

    /**
     * Retrieves a list of appointments based on an optional search key, such as a doctor's specialization.
     *
     * @param searchKey An optional search key to filter appointments.
     * @return A list of appointment responses.
     */
    public List<AppointmentSaveResponse> getAllAppointments(String searchKey) {
        List<Appointment> appointments;
        if (searchKey.isEmpty()) {
            appointments = appointmentRepository.findAll();
        } else {
            appointments = appointmentRepository.findByDoctor_Specialization_Name(searchKey);
        }
        return appointments.stream()
                .map(this::convertAppointmentToResponse)
                .toList();
    }

    /**
     * Confirms an appointment for a patient, changing its status to "CONFIRMED."
     *
     * @param appointmentNumber The unique appointment number.
     * @param patientNumber     The unique patient number.
     * @throws AppointmentAlreadyConfirmedException If the appointment is already confirmed.
     */
    public void confirmAppointment(String appointmentNumber, String patientNumber) {
        Patient patientByNumber = patientService.getByPatientNumber(patientNumber);
        Appointment appointment = getByAppointmentNumber(appointmentNumber);
        if (appointment.getAppointmentStatus() == AppointmentStatus.PENDING) {
            appointment.setAppointmentStatus(AppointmentStatus.CONFIRMED);
            patientService.addAppointmentToPatient(patientByNumber, appointment);
            appointmentRepository.save(appointment);
        } else if (appointment.getAppointmentStatus() == AppointmentStatus.CONFIRMED) {
            throw new AppointmentAlreadyConfirmedException("Appointment already confirmed.");
        }
    }

    protected Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found."));
    }

    protected String generateUniqueAppointmentNumber() {
        return UniqueNumberGeneratorUtils.generateUniqueNumber();
    }

    protected Appointment getByAppointmentNumber(String appointmentNumber) {
        return appointmentRepository.findByAppointmentNumber(appointmentNumber)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found."));

    }

    protected void scheduleAppointmentConfirmation(Appointment appointment) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (appointment.getAppointmentStatus() == AppointmentStatus.PENDING) {
                    appointment.setAppointmentStatus(AppointmentStatus.CANCELED);
                    appointmentRepository.save(appointment);
                }
            }
        }, 10 * 60 * 1000);
    }

    protected AppointmentSaveResponse convertAppointmentToResponse(Appointment appointment) {
        return AppointmentSaveResponse.builder()
                .appointmentId(appointment.getId())
                .doctor(doctorService.convertDoctorToResponse(appointment.getDoctor()))
                .appointmentDateTime(DateUtils.combineDateAndTime(
                        appointment.getAppointmentDate(), appointment.getAppointmentTime()))
                .build();
    }

    protected void checkPatientAvailability(Patient patient, Appointment appointment) {
        LocalDate requestAppointmentDate = appointment.getAppointmentDate();
        LocalTime requestAppointmentTime = appointment.getAppointmentTime();
        List<Appointment> appointments = patient.getAppointments();
        boolean patientHasAppointment = appointments.stream()
                .anyMatch(a ->
                        a.getAppointmentDate().isEqual(requestAppointmentDate)
                                && a.getAppointmentTime().equals(requestAppointmentTime));
        if (patientHasAppointment) {
            throw new PatientAlreadyHasAppointmentException(
                    "The patient already has an appointment at the specified date and time.");
        }
    }

    private Appointment buildAppointmentAndSave(AppointmentSaveRequest request) {
        Doctor doctor = doctorService.getDoctorById(request.getDoctorId());
        checkDoctorAvailability(doctor, request);
        LocalDate appointmentDate = DateUtils.parseLocalDate(request.getAppointmentDate());
        LocalTime appointmentTime = DateUtils.parseLocalTime(request.getAppointmentTime());
        Appointment appointment = Appointment.builder()
                .doctor(doctor)
                .appointmentDate(appointmentDate)
                .appointmentTime(appointmentTime)
                .build();
        return appointmentRepository.save(appointment);
    }

    private void checkDoctorAvailability(Doctor doctor, AppointmentSaveRequest request) {
        LocalDate requestAppointmentDate = DateUtils.parseLocalDate(request.getAppointmentDate());
        LocalTime requestAppointmentTime = DateUtils.parseLocalTime(request.getAppointmentTime());
        List<Appointment> appointments = doctor.getAppointments();
        boolean doctorHasAppointment = appointments.stream()
                .anyMatch(appointment ->
                        appointment.getAppointmentDate().isEqual(requestAppointmentDate)
                                && appointment.getAppointmentTime().equals(requestAppointmentTime));
        if (doctorHasAppointment) {
            throw new DoctorNotAvailableException(
                    "The doctor is not available at the specified date and time.");
        }
    }

    private void validateAppointmentSaveRequest(AppointmentSaveRequest request) {
        boolean anyFieldBlank = Stream.of(request.getDoctorId(),
                        request.getAppointmentDate(),
                        request.getAppointmentTime())
                .anyMatch(value -> value == null || value.toString().trim().isEmpty());
        if (anyFieldBlank) {
            throw new AppointmentValidationException("Required fields cannot be left blank");
        }
    }

}
