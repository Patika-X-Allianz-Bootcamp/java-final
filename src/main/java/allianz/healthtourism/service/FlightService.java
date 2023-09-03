package allianz.healthtourism.service;

import allianz.healthtourism.base.BaseService;
import allianz.healthtourism.dto.Request.DoctorRequest;
import allianz.healthtourism.dto.Request.FlightRequest;
import allianz.healthtourism.dto.Response.DoctorDTO;
import allianz.healthtourism.dto.Response.FlightDTO;
import allianz.healthtourism.entity.Doctor;
import allianz.healthtourism.entity.Flight;
import allianz.healthtourism.mapper.ModelMapperManager;
import allianz.healthtourism.repository.DoctorRepository;
import allianz.healthtourism.repository.FlightRepository;
import allianz.healthtourism.specification.DoctorSpecification;
import allianz.healthtourism.specification.FlightSpecification;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends BaseService<Flight, FlightDTO, FlightRequest, FlightRepository, FlightSpecification> {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightSpecification flightSpecification;


    public FlightService(ModelMapperManager modelMapperManager) {
        super(modelMapperManager);
    }

    @Override
    protected Class<Flight> getEntity() {
        return Flight.class;
    }

    @Override
    protected FlightRepository getRepository() {
        return flightRepository;
    }

    @Override
    protected FlightSpecification getSpecification() {
        return flightSpecification;
    }

    @Override
    protected Class<FlightDTO> getDto() {
        return FlightDTO.class;
    }

    @Override
    protected Class<FlightRequest> getRequestDto() {
        return FlightRequest.class;
    }
}
