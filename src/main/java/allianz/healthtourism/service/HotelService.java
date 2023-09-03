package allianz.healthtourism.service;

import allianz.healthtourism.base.BaseService;
import allianz.healthtourism.dto.Request.DoctorRequest;
import allianz.healthtourism.dto.Request.FlightRequest;
import allianz.healthtourism.dto.Request.HotelRequest;
import allianz.healthtourism.dto.Response.DoctorDTO;
import allianz.healthtourism.dto.Response.FlightDTO;
import allianz.healthtourism.dto.Response.HotelDTO;
import allianz.healthtourism.entity.Doctor;
import allianz.healthtourism.entity.Flight;
import allianz.healthtourism.entity.Hotel;
import allianz.healthtourism.mapper.ModelMapperManager;
import allianz.healthtourism.repository.DoctorRepository;
import allianz.healthtourism.repository.FlightRepository;
import allianz.healthtourism.repository.HotelRepository;
import allianz.healthtourism.specification.DoctorSpecification;
import allianz.healthtourism.specification.FlightSpecification;
import allianz.healthtourism.specification.HotelSpecification;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends BaseService<Hotel, HotelDTO, HotelRequest, HotelRepository, HotelSpecification> {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelSpecification hotelSpecification;


    public HotelService(ModelMapperManager modelMapperManager) {
        super(modelMapperManager);
    }

    @Override
    protected Class<Hotel> getEntity() {
        return Hotel.class;
    }

    @Override
    protected HotelRepository getRepository() {
        return hotelRepository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return hotelSpecification;
    }

    @Override
    protected Class<HotelDTO> getDto() {
        return HotelDTO.class;
    }

    @Override
    protected Class<HotelRequest> getRequestDto() {
        return HotelRequest.class;
    }
}
