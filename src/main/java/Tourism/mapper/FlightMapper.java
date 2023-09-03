package Tourism.mapper;

import Tourism.database.entity.DoctorEntity;
import Tourism.database.entity.FlightEntity;
import Tourism.model.DoctorDTO;
import Tourism.model.FlightDTO;
import Tourism.model.requestDTO.PageDTO;
import Tourism.model.requestDTO.RequestFlightDTO;
import Tourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightMapper implements IBaseMapper<FlightDTO, FlightEntity, RequestFlightDTO> {

    @Autowired
    @Lazy
    PatientMapper patientMapper;

    @Override
    public FlightDTO entityToDTO(FlightEntity entity) {
        FlightDTO dto = new FlightDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setAirline(entity.getAirline());
        dto.setFlightNumber(entity.getFlightNumber());
        dto.setDepartureAirport(entity.getDepartureAirport());
        dto.setArrivalAirport(entity.getArrivalAirport());
        dto.setDepartureDateTime(entity.getDepartureDateTime());
        dto.setArrivalDateTime(entity.getArrivalDateTime());
        dto.setPrice(entity.getPrice());
        dto.setAvailableSeats(entity.getAvailableSeats());
        if(entity.getPatientList()!=null){
            dto.setPatientList(patientMapper.entityListToDTOList(entity.getPatientList()));
        }
        return dto;
    }

    @Override
    public FlightEntity dtoToEntity(FlightDTO dto) {
        FlightEntity entity = new FlightEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setAirline(dto.getAirline());
        entity.setFlightNumber(dto.getFlightNumber());
        entity.setDepartureAirport(dto.getDepartureAirport());
        entity.setArrivalAirport(dto.getArrivalAirport());
        entity.setDepartureDateTime(dto.getDepartureDateTime());
        entity.setArrivalDateTime(dto.getArrivalDateTime());
        entity.setPrice(dto.getPrice());
        entity.setAvailableSeats(dto.getAvailableSeats());
        if(entity.getPatientList()!=null){
            entity.setPatientList(patientMapper.dtoListTOEntityList(dto.getPatientList()));
        }
        return entity;    }

    @Override
    public List<FlightDTO> entityListToDTOList(List<FlightEntity> flightEntities) {
        List<FlightDTO> dtoList = new ArrayList<>();
        for (FlightEntity entity : flightEntities) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;    }

    @Override
    public List<FlightEntity> dtoListTOEntityList(List<FlightDTO> flightDTOS) {
        List<FlightEntity> entityList = new ArrayList<>();
        for (FlightDTO dto : flightDTOS) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public FlightEntity requestDTOToEntity(RequestFlightDTO dto) {
        FlightEntity entity = new FlightEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setAirline(dto.getAirline());
        entity.setFlightNumber(dto.getFlightNumber());
        entity.setDepartureAirport(dto.getDepartureAirport());
        entity.setArrivalAirport(dto.getArrivalAirport());
        entity.setDepartureDateTime(dto.getDepartureDateTime());
        entity.setArrivalDateTime(dto.getArrivalDateTime());
        entity.setPrice(dto.getPrice());
        entity.setAvailableSeats(dto.getAvailableSeats());
        if(dto.getPatientList()!=null){
            entity.setPatientList(patientMapper.requestDtoListTOEntityList(dto.getPatientList()));
        }
        return entity;
    }

    @Override
    public List<FlightEntity> requestDtoListTOEntityList(List<RequestFlightDTO> requestFlightDTOS) {
        List<FlightEntity> entityList = new ArrayList<>();
        for (RequestFlightDTO dto : requestFlightDTOS) {
            entityList.add(requestDTOToEntity(dto));
        }
        return entityList;    }

    @Override
    public FlightEntity requestDtoToExistEntity(FlightEntity entity, RequestFlightDTO requestFlightDTO) {
        entity.setAirline(requestFlightDTO.getAirline());
        entity.setFlightNumber(requestFlightDTO.getFlightNumber());
        entity.setDepartureAirport(requestFlightDTO.getDepartureAirport());
        entity.setArrivalAirport(requestFlightDTO.getArrivalAirport());
        entity.setDepartureDateTime(requestFlightDTO.getDepartureDateTime());
        entity.setArrivalDateTime(requestFlightDTO.getArrivalDateTime());
        entity.setPrice(requestFlightDTO.getPrice());
        entity.setAvailableSeats(requestFlightDTO.getAvailableSeats());
        if(requestFlightDTO.getPatientList()!=null){
            entity.setPatientList(patientMapper.requestDtoListTOEntityList(requestFlightDTO.getPatientList()));
        }
        return entity;    }

    @Override
    public PageDTO<FlightDTO> pageEntityToPageDTO(Page<FlightEntity> entityPage) {
        PageDTO<FlightDTO> dtoPage = new PageDTO<>();
        dtoPage.setTotalPages(entityPage.getTotalPages());
        dtoPage.setTotalElements(entityPage.getTotalElements());
        dtoPage.setSort(entityPage.getSort());
        dtoPage.setSize(entityPage.getSize());
        dtoPage.setNumber(entityPage.getNumber());
        dtoPage.setContent(entityListToDTOList(entityPage.getContent()));
        dtoPage.setHasContent(entityPage.hasContent());

        return dtoPage;
    }
}
