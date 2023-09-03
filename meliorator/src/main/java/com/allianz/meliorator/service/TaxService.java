package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Tax;
import com.allianz.meliorator.database.repository.TaxRepository;
import com.allianz.meliorator.database.specification.TaxSpecification;
import com.allianz.meliorator.mapper.TaxMapper;
import com.allianz.meliorator.model.dto.TaxDTO;
import com.allianz.meliorator.model.requestDTO.TaxRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService extends BaseService<Tax, TaxDTO, TaxRequestDTO,
        TaxMapper, TaxRepository, TaxSpecification> {
    @Autowired
    TaxSpecification taxSpecification;
    @Autowired
    TaxMapper taxMapper;
    @Autowired
    TaxRepository taxRepository;
    @Override
    protected TaxMapper getMapper() {
        return null;
    }

    @Override
    protected TaxRepository getRepository() {
        return null;
    }

    @Override
    protected TaxSpecification getSpecification() {
        return this.taxSpecification;
    }
}
