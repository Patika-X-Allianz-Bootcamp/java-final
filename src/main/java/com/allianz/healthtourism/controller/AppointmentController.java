package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.repository.AppointmentRepository;
import com.allianz.healthtourism.database.specification.AppointmentSpecification;
import com.allianz.healthtourism.mapper.AppointmentMapper;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.healthtourism.service.AppointmentService;
import com.allianz.healthtourism.util.BaseController;
import com.allianz.healthtourism.util.pageable.BaseFilterRequestDTO;
import com.allianz.healthtourism.util.pageable.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
@RequiredArgsConstructor
public class AppointmentController extends BaseController<AppointmentRequestDTO, AppointmentResponseDTO, AppointmentEntity, AppointmentMapper, AppointmentRepository, AppointmentSpecification, AppointmentService> {
    private final AppointmentService appService;

    @Override
    protected AppointmentService getService() {
        return appService;
    }

    @PostMapping("save-with-id")
    public ResponseEntity<AppointmentResponseDTO> saveWithId(@RequestBody AppointmentRequestDTO requestDTO) {
        return new ResponseEntity<>(getService().saveWithId(requestDTO), HttpStatus.CREATED);
    }

}
