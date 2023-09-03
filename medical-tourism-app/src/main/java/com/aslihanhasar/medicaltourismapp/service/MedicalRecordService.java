package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.MedicalRecordRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.MedicalRecordResponse;
import com.aslihanhasar.medicaltourismapp.entity.Appointment;
import com.aslihanhasar.medicaltourismapp.entity.MedicalRecord;
import com.aslihanhasar.medicaltourismapp.exception.MedicalRecordValidationException;
import com.aslihanhasar.medicaltourismapp.repository.MedicalRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Service class responsible for managing medical records, including creation and retrieval of medical records.
 */
@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final AppointmentService appointmentService;

    /**
     * Creates a new medical record based on the provided request and saves it to the database.
     *
     * @param request The request containing medical record details.
     * @return A response containing information about the created medical record.
     */
    public MedicalRecordResponse createMedicalRecord(MedicalRecordRequest request) {
        validateMedicalRecordSaveRequest(request);
        MedicalRecord medicalRecord = buildAndSaveMedicalRecord(request);
        return convertMedicalRecordToResponse(medicalRecord);
    }

    private MedicalRecord buildAndSaveMedicalRecord(MedicalRecordRequest request) {
        Appointment appointment = appointmentService.getAppointmentById(request.getAppointmentId());
        MedicalRecord medicalRecord = MedicalRecord
                .builder()
                .appointment(appointment)
                .examinationNotes(request.getExaminationNotes())
                .build();
        return medicalRecordRepository.save(medicalRecord);
    }

    private MedicalRecordResponse convertMedicalRecordToResponse(MedicalRecord medicalRecord) {
        return MedicalRecordResponse
                .builder()
                .medicalRecordId(medicalRecord.getId())
                .appointmentId(medicalRecord.getAppointment().getId())
                .examinationNotes(medicalRecord.getExaminationNotes())
                .build();
    }

    private void validateMedicalRecordSaveRequest(MedicalRecordRequest request) {
        boolean anyFieldBlank = Stream.of(request.getAppointmentId(),
                        request.getExaminationNotes())
                .anyMatch(Objects::isNull);
        if (anyFieldBlank) {
            throw new MedicalRecordValidationException("Required fields cannot be left blank");
        }
    }
}
