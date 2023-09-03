package com.healthtourism.healthtourism.service;

import com.healthtourism.healthtourism.Specification.MedicalRecordSpecification;
import com.healthtourism.healthtourism.database.entities.AppointmentEntity;
import com.healthtourism.healthtourism.database.entities.MedicalRecordEntity;
import com.healthtourism.healthtourism.database.repositories.AppointmentRepository;
import com.healthtourism.healthtourism.database.repositories.MedicalRecordRepository;
import com.healthtourism.healthtourism.mapper.MedicalRecordMapper;
import com.healthtourism.healthtourism.model.MedicalRecordDTO;
import com.healthtourism.healthtourism.model.RequestDTO.MedicalRecordRequestDTO;
import com.healthtourism.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MedicalRecordService extends BaseService<
        MedicalRecordEntity,
        MedicalRecordDTO,
        MedicalRecordRequestDTO,
        MedicalRecordMapper,
        MedicalRecordRepository,
        MedicalRecordSpecification> {

    @Autowired
    MedicalRecordMapper medicalRecordMapper;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    MedicalRecordRepository medicalRecordRepository;
    @Autowired
    MedicalRecordSpecification medicalRecordSpecification;


    @Override
    public MedicalRecordMapper getMapper() {
        return medicalRecordMapper;
    }

    @Override
    public MedicalRecordRepository getRepository() {
        return medicalRecordRepository;
    }

    @Override
    protected MedicalRecordSpecification getSpecification() {
        return medicalRecordSpecification;
    }

    public MedicalRecordEntity createMedicalRecord(Long appointmentId, String examinationNotes) {
        // Verilen randevu kimliği ile randevuyu bulun
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findById(appointmentId);

        if (appointmentOptional.isPresent()) {
            // Randevuyu bulun
            AppointmentEntity appointment = appointmentOptional.get();

            // Doktorun kimlik doğrulaması yapılmalı (örneğin, oturum açılmış olmalıdır)
            // Sadece randevu ilişkisindeki doktor kendi hastasına rapor yazabilir

            // Rapor oluşturma işlemi
            MedicalRecordEntity medicalRecord = new MedicalRecordEntity();
            medicalRecord.setExaminationNotes(examinationNotes);
            medicalRecord.setPatient(appointment.getPatient()); // Randevu ile aynı hastayı kullan
            medicalRecord.setDoctor(appointment.getDoctor()); // Randevu ile aynı doktoru kullan

            // Raporu kaydedin
            return medicalRecordRepository.save(medicalRecord);
        } else {
            // Randevu bulunamadı
            throw new NoSuchElementException("Randevu bulunamadı");
        }
    }
}
