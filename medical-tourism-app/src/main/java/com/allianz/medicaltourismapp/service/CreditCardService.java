package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.CreditCardEntity;
import com.allianz.medicaltourismapp.database.repository.CreditCardEntityRepository;
import com.allianz.medicaltourismapp.database.repository.CreditCardEntityRepository;
import com.allianz.medicaltourismapp.database.specification.CreditCardSpecification;
import com.allianz.medicaltourismapp.database.specification.CreditCardSpecification;
import com.allianz.medicaltourismapp.mapper.CreditCardMapper;
import com.allianz.medicaltourismapp.mapper.CreditCardMapper;
import com.allianz.medicaltourismapp.model.CreditCardDTO;
import com.allianz.medicaltourismapp.util.BaseService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreditCardService extends BaseService<
        CreditCardDTO,
        CreditCardEntity,
        CreditCardEntityRepository,
        CreditCardMapper,
        CreditCardSpecification> {

    private final CreditCardEntityRepository creditCardEntityRepository;


    private final CreditCardSpecification creditCardSpecification;
    private final CreditCardMapper creditCardMapper;

    @Override
    protected CreditCardMapper getMapper() {
        return creditCardMapper;
    }

    @Override
    protected CreditCardEntityRepository getRepository() {
        return creditCardEntityRepository;
    }

    @Override
    protected CreditCardSpecification getSpecification() {
        return creditCardSpecification;
    }
}