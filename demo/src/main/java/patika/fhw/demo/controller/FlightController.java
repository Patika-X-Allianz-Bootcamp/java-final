package patika.fhw.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import patika.fhw.demo.database.entity.Flight;
import patika.fhw.demo.database.repository.FlightRepository;
import patika.fhw.demo.database.specification.FlightSpecification;
import patika.fhw.demo.mapper.FlightMapper;
import patika.fhw.demo.model.dto.FlightDTO;
import patika.fhw.demo.model.requestDTO.FlightRequestDTO;
import patika.fhw.demo.service.FlightService;
import patika.fhw.demo.util.BaseController;

@RestController
@RequestMapping("flight")
public class FlightController extends BaseController<
        Flight,
        FlightDTO,
        FlightRequestDTO,
        FlightMapper,
        FlightRepository,
        FlightSpecification,
        FlightService> {

    @Autowired
    private FlightService flightService;

    @Override
    protected FlightService getService() {
        return flightService;
    }
}
