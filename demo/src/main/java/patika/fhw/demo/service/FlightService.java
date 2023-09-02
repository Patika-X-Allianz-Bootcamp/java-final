package patika.fhw.demo.service;

import org.springframework.stereotype.Service;

import patika.fhw.demo.database.entity.Flight;
import patika.fhw.demo.database.repository.FlightRepository;
import patika.fhw.demo.database.specification.FlightSpecification;
import patika.fhw.demo.mapper.FlightMapper;
import patika.fhw.demo.model.dto.FlightDTO;
import patika.fhw.demo.model.requestDTO.FlightRequestDTO;
import patika.fhw.demo.util.BaseService;

@Service
public class FlightService extends BaseService<Flight, FlightDTO, FlightRequestDTO, FlightMapper, FlightRepository, FlightSpecification> {

    private final FlightMapper mapper;
    private final FlightRepository repository;
    private final FlightSpecification specification;

    public FlightService(FlightMapper mapper, FlightRepository repository, FlightSpecification specification) {
        this.mapper = mapper;
        this.repository = repository;
        this.specification = specification;
    }

    @Override
    protected FlightMapper getMapper() {
        return mapper;
    }

    @Override
    protected FlightRepository getRepository() {
        return repository;
    }

    @Override
    protected FlightSpecification getSpecification() {
        return specification;
    }
}
