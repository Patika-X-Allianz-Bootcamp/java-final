package com.healthtourism.healthtourism.controller;

import com.healthtourism.healthtourism.Specification.MedicalRecordSpecification;
import com.healthtourism.healthtourism.database.entities.MedicalRecordEntity;
import com.healthtourism.healthtourism.database.repositories.MedicalRecordRepository;
import com.healthtourism.healthtourism.mapper.MedicalRecordMapper;
import com.healthtourism.healthtourism.model.MedicalRecordDTO;
import com.healthtourism.healthtourism.model.RequestDTO.MedicalRecordRequestDTO;
import com.healthtourism.healthtourism.service.MedicalRecordService;
import com.healthtourism.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController extends BaseController<
        MedicalRecordEntity,
        MedicalRecordDTO,
        MedicalRecordRequestDTO,
        MedicalRecordMapper,
        MedicalRecordRepository,
        MedicalRecordService,
        MedicalRecordSpecification> {
    @Autowired
    MedicalRecordService medicalRecordService;
    @Override
    protected MedicalRecordService getService() {
        return medicalRecordService;
    }

    // Yeni bir tıbbi rapor oluşturmak için POST isteği
    @PostMapping("/create")
    public ResponseEntity<MedicalRecordEntity> createMedicalRecord(
            @RequestParam Long appointmentId,
            @RequestParam String examinationNotes
    ) {
        try {
            // Tıbbi raporu oluştur
            MedicalRecordEntity medicalRecord = medicalRecordService.createMedicalRecord(appointmentId, examinationNotes);
            return new ResponseEntity<>(medicalRecord, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
