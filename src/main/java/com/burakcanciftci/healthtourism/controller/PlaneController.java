package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.PlaneEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.PlaneRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.PlaneResponseDTO;
import com.burakcanciftci.healthtourism.service.PlaneService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("plane")
@AllArgsConstructor
public class PlaneController extends BaseController<PlaneEntity, PlaneResponseDTO, PlaneRequestDTO> {
    private final PlaneService planeService;

    @Override
    protected PlaneService getService() {
        return this.planeService;
    }
}
