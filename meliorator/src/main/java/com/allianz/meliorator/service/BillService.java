package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Bill;
import com.allianz.meliorator.database.repository.BillRepository;
import com.allianz.meliorator.database.specification.AppointmentSpecification;
import com.allianz.meliorator.database.specification.BillSpecification;
import com.allianz.meliorator.mapper.BillMapper;
import com.allianz.meliorator.model.dto.BillDTO;
import com.allianz.meliorator.model.requestDTO.BillRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService extends BaseService<Bill, BillDTO, BillRequestDTO, BillMapper,
        BillRepository, BillSpecification> {
    @Autowired
    BillSpecification billSpecification;
    @Autowired
    BillMapper billMapper;
    @Autowired
    BillRepository billRepository;
    @Override
    protected BillMapper getMapper() {
        return this.billMapper;
    }

    @Override
    protected BillRepository getRepository() {
        return this.billRepository;
    }

    @Override
    protected BillSpecification getSpecification() {
        return this.billSpecification;
    }
}
