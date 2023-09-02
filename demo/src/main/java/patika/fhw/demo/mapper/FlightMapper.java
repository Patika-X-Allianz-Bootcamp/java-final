package patika.fhw.demo.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import patika.fhw.demo.database.entity.Flight;
import patika.fhw.demo.model.dto.FlightDTO;
import patika.fhw.demo.model.requestDTO.FlightRequestDTO;
import patika.fhw.demo.model.requestDTO.PageDTO;
import patika.fhw.demo.util.BaseMapper;

@Component
public class FlightMapper implements BaseMapper<FlightDTO, Flight, FlightRequestDTO> {

    private final DateFormat dateFormat;

    public FlightMapper(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public FlightDTO entityToDTO(Flight entity) {
        FlightDTO dto = new FlightDTO();
        dto.setId(entity.getId());
        dto.setAirline(entity.getAirline());
        dto.setDepartureAirport(entity.getDepartureAirport());
        dto.setArrivalAirport(entity.getArrivalAirport());
        dto.setDepartureTime(entity.getDepartureTime());
        dto.setArrivalTime(entity.getArrivalTime());
        return dto;
    }

    @Override
    public Flight dtoToEntity(FlightDTO dto) {
        Flight entity = new Flight();
        entity.setId(dto.getId());
        entity.setAirline(dto.getAirline());
        entity.setDepartureAirport(dto.getDepartureAirport());
        entity.setArrivalAirport(dto.getArrivalAirport());
        entity.setDepartureTime(dto.getDepartureTime());
        entity.setArrivalTime(dto.getArrivalTime());
        return entity;
    }

    @Override
    public List<FlightDTO> entityListToDTOList(List<Flight> entityList) {
        return entityList.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Flight> dtoListTOEntityList(List<FlightDTO> dtoList) {
        return dtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public Flight requestDTOToEntity(FlightRequestDTO dto) {
        Flight entity = new Flight();
        entity.setAirline(dto.getAirline());
        entity.setDepartureAirport(dto.getDepartureAirport());
        entity.setArrivalAirport(dto.getArrivalAirport());
        try {
            entity.setDepartureTime(dateFormat.parse(dto.getDepartureTime()));
            entity.setArrivalTime(dateFormat.parse(dto.getArrivalTime()));
        } catch (ParseException e) {
        }
        return entity;
    }

    @Override
    public List<Flight> requestDtoListTOEntityList(List<FlightRequestDTO> dtoList) {
        return dtoList.stream().map(this::requestDTOToEntity).collect(Collectors.toList());
    }

    @Override
    public Flight requestDtoToExistEntity(Flight entity, FlightRequestDTO requestDTO) {
        
        entity.setAirline(requestDTO.getAirline());
        entity.setDepartureAirport(requestDTO.getDepartureAirport());
        entity.setArrivalAirport(requestDTO.getArrivalAirport());
        try {
            entity.setDepartureTime(dateFormat.parse(requestDTO.getDepartureTime()));
            entity.setArrivalTime(dateFormat.parse(requestDTO.getArrivalTime()));
        } catch (ParseException e) {
            
        }
        
        return entity;
    }


    @Override
    public PageDTO<FlightDTO> pageEntityToPageDTO(Page<Flight> entityPage) {
        PageDTO<FlightDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(entityListToDTOList(entityPage.getContent()));
        pageDTO.setTotalPages(entityPage.getTotalPages());
        pageDTO.setTotalElements(entityPage.getTotalElements());
        pageDTO.setCurrentPage(entityPage.getNumber());
        pageDTO.setSize(entityPage.getSize());
        return pageDTO;
    }
}
