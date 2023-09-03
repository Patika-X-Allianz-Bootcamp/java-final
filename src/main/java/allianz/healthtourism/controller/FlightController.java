package allianz.healthtourism.controller;

import allianz.healthtourism.base.BaseController;

import allianz.healthtourism.dto.Request.FlightRequest;
import allianz.healthtourism.dto.Response.FlightDTO;
import allianz.healthtourism.entity.Flight;
import allianz.healthtourism.repository.FlightRepository;
import allianz.healthtourism.service.FlightService;
import allianz.healthtourism.specification.FlightSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController extends BaseController<
        Flight,
        FlightDTO,
        FlightRequest,
        FlightRepository,
        FlightSpecification,
        FlightService> {


    @Autowired
    FlightService flightService;


    @Override
    protected FlightService getService() {
        return flightService;
    }


}
