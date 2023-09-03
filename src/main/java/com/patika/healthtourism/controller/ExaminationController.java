package com.patika.healthtourism.controller;

import com.patika.healthtourism.database.entity.ExaminationEntity;
import com.patika.healthtourism.database.repository.ExaminationEntityRepository;
import com.patika.healthtourism.mapper.ExaminationMapper;
import com.patika.healthtourism.model.ExaminationDTO;
import com.patika.healthtourism.model.requestDTO.ExaminationCreateRequestDTO;
import com.patika.healthtourism.service.ExaminationService;
import com.patika.healthtourism.util.BaseController;
import com.patika.healthtourism.util.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/examination")
public class ExaminationController extends BaseController<ExaminationEntity, ExaminationDTO, ExaminationCreateRequestDTO,
        ExaminationMapper, ExaminationEntityRepository, ExaminationService> {
    private final ExaminationService examinationService;

    public ExaminationController(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @Override
    protected ExaminationService getService() {
        return examinationService;
    }
    @PostMapping("/create/{appointmentUuid}")
    public ResponseEntity<ExaminationDTO> createExamination(@PathVariable UUID appointmentUuid,
                                                            @RequestBody ExaminationCreateRequestDTO examinationCreateRequestDTO){
        ExaminationDTO examination = examinationService.createExamination(appointmentUuid, examinationCreateRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(examination);
    }
}
