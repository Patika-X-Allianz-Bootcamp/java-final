package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Country;
import com.allianz.meliorator.database.repository.CountryRepository;
import com.allianz.meliorator.mapper.CountryMapper;
import com.allianz.meliorator.model.dto.CountryDTO;
import com.allianz.meliorator.model.requestDTO.CountryRequestDTO;
import com.allianz.meliorator.service.CountryService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController extends BaseController<Country, CountryDTO, CountryRequestDTO,
        CountryMapper, CountryRepository, CountryService> {
    @Autowired
    CountryService countryService;
    @Override
    protected CountryService getService() {
        return this.countryService;
    }
}
