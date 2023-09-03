package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Housing;
import com.allianz.meliorator.database.repository.HousingRepository;
import com.allianz.meliorator.mapper.HousingMapper;
import com.allianz.meliorator.model.dto.HousingDTO;
import com.allianz.meliorator.model.requestDTO.HousingRequestDTO;
import com.allianz.meliorator.service.HousingService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/housing")
public class HousingController extends BaseController<Housing, HousingDTO, HousingRequestDTO,
       HousingMapper, HousingRepository, HousingService> {
    @Autowired
    HousingService housingService;
    @Override
    protected HousingService getService() {
        return this.housingService;
    }
}
