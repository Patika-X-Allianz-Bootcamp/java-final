package allianz.healthtourism.controller;

import allianz.healthtourism.base.BaseController;
import allianz.healthtourism.dto.Request.DoctorRequest;
import allianz.healthtourism.dto.Request.ExaminationRequest;
import allianz.healthtourism.dto.Response.DoctorDTO;
import allianz.healthtourism.dto.Response.ExaminationDTO;
import allianz.healthtourism.entity.Doctor;
import allianz.healthtourism.entity.Examination;
import allianz.healthtourism.repository.DoctorRepository;
import allianz.healthtourism.repository.ExaminationRepository;
import allianz.healthtourism.service.DoctorService;
import allianz.healthtourism.service.ExaminationService;
import allianz.healthtourism.specification.DoctorSpecification;
import allianz.healthtourism.specification.ExaminationSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("examination")
public class ExaminationController extends BaseController<
        Examination,
        ExaminationDTO,
        ExaminationRequest,
        ExaminationRepository,
        ExaminationSpecification,
        ExaminationService> {

    @Autowired
    ExaminationService examinationService;


    @Override
    protected ExaminationService getService() {
        return examinationService;
    }

    @PostMapping("/create-examination")
    public ResponseEntity<ExaminationDTO> createExamination(@RequestParam UUID appointmentUuid, @RequestBody ExaminationRequest examinationRequest) {
        return new ResponseEntity<>(examinationService.createExamination(appointmentUuid,examinationRequest), HttpStatus.CREATED);
    }
}
