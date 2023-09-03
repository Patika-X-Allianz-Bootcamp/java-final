package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.ExaminationCardEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.ExaminationCardRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.ExaminationCardResponseDTO;
import com.burakcanciftci.healthtourism.service.ExaminationCardService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("examination-card")
@AllArgsConstructor
public class ExaminationCardController extends BaseController<ExaminationCardEntity, ExaminationCardResponseDTO, ExaminationCardRequestDTO> {
    private final ExaminationCardService examinationCardService;

    @Override
    protected ExaminationCardService getService() {
        return this.examinationCardService;
    }
}
