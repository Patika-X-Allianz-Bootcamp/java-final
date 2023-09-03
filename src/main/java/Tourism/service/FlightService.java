package Tourism.service;

import Tourism.database.entity.FlightEntity;
import Tourism.database.repository.FlightRepository;
import Tourism.database.specification.FlightSpecification;
import Tourism.mapper.FlightMapper;
import Tourism.model.FlightDTO;
import Tourism.model.requestDTO.RequestFlightDTO;
import Tourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends BaseService<FlightEntity, FlightDTO, RequestFlightDTO,
        FlightMapper, FlightRepository, FlightSpecification> {

    @Autowired
    FlightMapper flightMapper;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightSpecification flightSpecification;

    @Override
    protected FlightMapper getMapper() {
        return flightMapper;
    }

    @Override
    protected FlightRepository getRepository() {
        return flightRepository;
    }

    @Override
    protected FlightSpecification getSpecification() {
        return flightSpecification;
    }
}
