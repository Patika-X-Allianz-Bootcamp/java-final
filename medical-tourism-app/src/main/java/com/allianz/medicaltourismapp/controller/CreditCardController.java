package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.CreditCardEntity;
import com.allianz.medicaltourismapp.database.repository.CreditCardEntityRepository;
import com.allianz.medicaltourismapp.database.specification.CreditCardSpecification;
import com.allianz.medicaltourismapp.mapper.CreditCardMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.CreditCardDTO;
import com.allianz.medicaltourismapp.service.CreditCardService;
import com.allianz.medicaltourismapp.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("creditcard")
@RequiredArgsConstructor
public class CreditCardController extends BaseController<
        CreditCardEntity,
        CreditCardDTO,
        CreditCardMapper,
        CreditCardEntityRepository,
        CreditCardSpecification, CreditCardService
        > {

    @Autowired
    CreditCardMapper creditCardMapper;

    @Override
    protected CreditCardMapper getMapper() {
        return creditCardMapper;
    }

    @Autowired
    CreditCardService creditCardService;
    @Override
    protected CreditCardService getService() {
        return creditCardService;
    }
}