package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.*;
import com.allianz.healthtourism.database.repository.DoctorRepository;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.database.specification.DoctorSpecification;
import com.allianz.healthtourism.database.specification.FlightSpecification;
import com.allianz.healthtourism.mapper.DoctorMapper;
import com.allianz.healthtourism.mapper.FlightMapper;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.model.requestDTO.PlaneRequestDTO;
import com.allianz.healthtourism.model.responseDTO.*;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FlightService extends BaseService<FlightResponseDTO, FlightRequestDTO, FlightEntity, FlightMapper, FlightRepository, FlightSpecification> {
    private final FlightRepository repository;
    private final FlightSpecification specification;
    private final PlaneService planeService;
    @Override
    protected FlightMapper getMapper() {
        return FlightMapper.INSTANCE;
    }
    @Override
    protected FlightRepository getRepository() {
        return repository;
    }
    @Override
    protected FlightSpecification getSpecification() {
        return specification;
    }

    @Override
    public FlightResponseDTO save(FlightRequestDTO requestDTO) {
        PlaneEntity planeEntity = planeService.findById(requestDTO.getPlaneId());
        FlightEntity flightEntity = getMapper().requestDtoToEntity(requestDTO);
        List<SeatEntity> seats = new ArrayList<>();
        for(int i = 0; i < planeEntity.getSeatCount(); i++){
            SeatEntity seat = new SeatEntity();
            seat.setSeatNo(i+1);
            seat.setAvailable(true);
            seats.add(seat);
        }
        flightEntity.setSeats(seats);
        flightEntity = getRepository().save(flightEntity);
        return getMapper().entityToResponseDto(flightEntity);
    }

    public List<FlightForPatientResponseDTO> findByCityName(String cityFromName, String cityToName){
        List<FlightEntity> flightEntities = getRepository().findByCityFromNameAndAndCityToName(cityFromName,cityToName);
        return getMapper().entityListToResponseDtoListForPatient(flightEntities);
    }
}
