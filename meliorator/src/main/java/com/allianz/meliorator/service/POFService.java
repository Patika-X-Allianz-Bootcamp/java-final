package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.PlanOfFlight;
import com.allianz.meliorator.database.repository.POFRepository;
import com.allianz.meliorator.database.specification.POFSpecification;
import com.allianz.meliorator.mapper.POFMapper;
import com.allianz.meliorator.model.dto.POFDTO;
import com.allianz.meliorator.model.requestDTO.POFReqDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class POFService extends BaseService<PlanOfFlight, POFDTO, POFReqDTO,
        POFMapper, POFRepository, POFSpecification> {
    @Autowired
    POFSpecification pofSpecification;
    @Autowired
    POFMapper pofMapper;
    @Autowired
    POFRepository pofRepository;
    @Override
    protected POFMapper getMapper() {
        return this.pofMapper;
    }

    @Override
    protected POFRepository getRepository() {
        return this.pofRepository;
    }

    @Override
    protected POFSpecification getSpecification() {
        return this.pofSpecification;
    }
}
