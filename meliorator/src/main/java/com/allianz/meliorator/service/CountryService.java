package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Country;
import com.allianz.meliorator.database.repository.CountryRepository;
import com.allianz.meliorator.database.specification.CountrySpecification;
import com.allianz.meliorator.mapper.CountryMapper;
import com.allianz.meliorator.model.dto.CountryDTO;
import com.allianz.meliorator.model.requestDTO.CountryRequestDTO;
import com.allianz.meliorator.util.BaseService;
import com.allianz.meliorator.util_db.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends BaseService<Country, CountryDTO, CountryRequestDTO,
        CountryMapper, CountryRepository, CountrySpecification> {
    @Autowired
    CountrySpecification countrySpecification;
    @Autowired
    CountryMapper countryMapper;
    @Autowired
    CountryRepository countryRepository;
    @Override
    protected CountryMapper getMapper() {
        return this.countryMapper;
    }

    @Override
    protected CountryRepository getRepository() {
        return this.countryRepository;
    }

    @Override
    protected CountrySpecification getSpecification() {
        return this.countrySpecification;
    }
}
