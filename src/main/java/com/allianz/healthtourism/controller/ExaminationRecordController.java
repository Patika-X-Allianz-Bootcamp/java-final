package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.ExaminationRecordEntity;
import com.allianz.healthtourism.database.repository.DoctorRepository;
import com.allianz.healthtourism.database.repository.ExaminationRecordRepository;
import com.allianz.healthtourism.database.specification.DoctorSpecification;
import com.allianz.healthtourism.database.specification.ExaminationRecordSpecification;
import com.allianz.healthtourism.mapper.DoctorMapper;
import com.allianz.healthtourism.mapper.ExaminationRecordMapper;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.model.requestDTO.ExaminationRecordRequestDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorResponseDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationRecordResponseDTO;
import com.allianz.healthtourism.service.DoctorService;
import com.allianz.healthtourism.service.ExaminationRecordService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("examination-record")
@RequiredArgsConstructor
public class ExaminationRecordController extends BaseController<ExaminationRecordRequestDTO,
        ExaminationRecordResponseDTO,
        ExaminationRecordEntity,
        ExaminationRecordMapper,
        ExaminationRecordRepository,
        ExaminationRecordSpecification,
        ExaminationRecordService> {
    private final ExaminationRecordService service;

    @Override
    protected ExaminationRecordService getService() {
        return service;
    }

    @Override
    @PostMapping
    public ResponseEntity<ExaminationRecordResponseDTO> save(@RequestBody ExaminationRecordRequestDTO requestDTO) {
        ExaminationRecordResponseDTO responseDTO = getService().saveWithId(requestDTO);
        if (responseDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);    }
}
