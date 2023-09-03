package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.ExaminationEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.ExaminationAddCardRequestDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.ExaminationRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.ExaminationResponseDTO;
import com.burakcanciftci.healthtourism.service.ExaminationService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("examination")
@AllArgsConstructor
public class ExaminationController extends BaseController<ExaminationEntity, ExaminationResponseDTO, ExaminationRequestDTO> {
    private final ExaminationService examinationService;

    @Override
    protected ExaminationService getService() {
        return this.examinationService;
    }

    @PostMapping("reserve")
    public ResponseEntity<ExaminationResponseDTO> reserveSeat(
            @RequestBody ExaminationRequestDTO examinationRequestDTO){
        ExaminationResponseDTO examinationResponseDTO =
                examinationService.createAppointment(examinationRequestDTO);

        if(examinationResponseDTO != null){
            return new ResponseEntity<>(examinationResponseDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("add-card/{uuid}")
    public ResponseEntity<ExaminationResponseDTO> addCard(
            @PathVariable UUID uuid,
            @RequestBody ExaminationAddCardRequestDTO examinationAddCardRequestDTO){
        ExaminationResponseDTO examinationResponseDTO =
                examinationService.addCard(uuid, examinationAddCardRequestDTO);

        if(examinationResponseDTO != null){
            return new ResponseEntity<>(examinationResponseDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}