package Tourism.controller;

import Tourism.database.entity.FlightEntity;
import Tourism.database.repository.FlightRepository;
import Tourism.database.specification.FlightSpecification;
import Tourism.mapper.FlightMapper;
import Tourism.model.FlightDTO;
import Tourism.model.requestDTO.RequestFlightDTO;
import Tourism.service.FlightService;
import Tourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController extends BaseController<
        FlightEntity,
        FlightDTO,
        RequestFlightDTO,
        FlightMapper,
        FlightRepository,
        FlightSpecification,
        FlightService> {

    @Autowired
    FlightService flightService;

    @Override
    protected FlightService getService() {
        return this.flightService;
    }
}