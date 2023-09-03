package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Plane;
import com.allianz.meliorator.database.repository.PlaneRepository;
import com.allianz.meliorator.mapper.PlaneMapper;
import com.allianz.meliorator.model.dto.PlaneDTO;
import com.allianz.meliorator.model.requestDTO.PlaneRequestDTO;
import com.allianz.meliorator.service.PlaneService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plane")
public class PlaneController extends BaseController<Plane, PlaneDTO, PlaneRequestDTO,
        PlaneMapper, PlaneRepository, PlaneService> {
    @Autowired
    PlaneService planeService;
    @Override
    protected PlaneService getService() {
        return planeService;
    }
}
