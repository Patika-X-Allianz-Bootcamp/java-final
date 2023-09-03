package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.PlanOfFlight;
import com.allianz.meliorator.database.repository.POFRepository;
import com.allianz.meliorator.mapper.POFMapper;
import com.allianz.meliorator.model.dto.POFDTO;
import com.allianz.meliorator.model.requestDTO.POFReqDTO;
import com.allianz.meliorator.service.POFService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planeOfFlight")
public class FlightPlanController extends BaseController<PlanOfFlight, POFDTO, POFReqDTO, POFMapper, POFRepository, POFService> {
    @Autowired
    POFService pofService;
    @Override
    protected POFService getService() {
        return this.pofService;
    }
}
