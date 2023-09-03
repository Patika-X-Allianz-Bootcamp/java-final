package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Tax;
import com.allianz.meliorator.database.repository.TaxRepository;
import com.allianz.meliorator.mapper.TaxMapper;
import com.allianz.meliorator.model.dto.TaxDTO;
import com.allianz.meliorator.model.requestDTO.TaxRequestDTO;
import com.allianz.meliorator.service.TaxService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
public class TaxController extends BaseController<Tax, TaxDTO, TaxRequestDTO, TaxMapper,
        TaxRepository, TaxService> {
    @Autowired
    TaxService taxService;

    @Override
    protected TaxService getService() {
        return this.taxService;
    }
}
