package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.AirlineCompanyEntity;
import com.tourismcorp.healthtourism.model.AirlineCompanyDTO;
import com.tourismcorp.healthtourism.model.requestDTO.AirlineCompanyRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirlineCompanyMapper implements IBaseMapper<AirlineCompanyEntity,
        AirlineCompanyDTO, AirlineCompanyRequestDTO> {

    private final FlightMapper flightMapper;
    private final BankAccountMapper bankAccountMapper;

    @Autowired
    protected AirlineCompanyMapper(FlightMapper flightMapper, BankAccountMapper bankAccountMapper) {
        this.flightMapper = flightMapper;
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public AirlineCompanyDTO entityToDTO(AirlineCompanyEntity entity) {
        AirlineCompanyDTO airlineCompanyDTO = new AirlineCompanyDTO();
        airlineCompanyDTO.setUuid(entity.getUuid());
        airlineCompanyDTO.setCreationDate(entity.getCreationDate());
        airlineCompanyDTO.setUpdatedDate(entity.getUpdatedDate());
        airlineCompanyDTO.setId(entity.getId());
        airlineCompanyDTO.setCompanyName(entity.getCompanyName());
        airlineCompanyDTO.setPhoneNumber(entity.getPhoneNumber());
        airlineCompanyDTO.setEmail(entity.getEmail());
        airlineCompanyDTO.setFlight(flightMapper.entityListToDTOList(entity.getFlight()));
        if (entity.getBankAccount() == null)
            airlineCompanyDTO.setBankAccount(null);
        else
            airlineCompanyDTO.setBankAccount(bankAccountMapper.entityToDTO(entity.getBankAccount()));

        return airlineCompanyDTO;
    }

    @Override
    public AirlineCompanyEntity dtoToEntity(AirlineCompanyDTO dto) {
        AirlineCompanyEntity airlineCompanyEntity = new AirlineCompanyEntity();
        airlineCompanyEntity.setUuid(dto.getUuid());
        airlineCompanyEntity.setCreationDate(dto.getCreationDate());
        airlineCompanyEntity.setUpdatedDate(dto.getUpdatedDate());
        airlineCompanyEntity.setId(dto.getId());
        airlineCompanyEntity.setCompanyName(dto.getCompanyName());
        airlineCompanyEntity.setPhoneNumber(dto.getPhoneNumber());
        airlineCompanyEntity.setEmail(dto.getEmail());
        airlineCompanyEntity.setFlight(flightMapper.dtoListToEntityList(dto.getFlight()));
        if (dto.getBankAccount() == null)
            airlineCompanyEntity.setBankAccount(null);
        else
            airlineCompanyEntity.setBankAccount(bankAccountMapper.dtoToEntity(dto.getBankAccount()));

        return airlineCompanyEntity;
    }

    @Override
    public List<AirlineCompanyDTO> entityListToDTOList(List<AirlineCompanyEntity> airlineCompanyEntities) {
        List<AirlineCompanyDTO> airlineCompanyDTOList = new ArrayList<>();
        for (AirlineCompanyEntity entity : airlineCompanyEntities) {
            AirlineCompanyDTO dto = entityToDTO(entity);
            airlineCompanyDTOList.add(dto);
        }
        return airlineCompanyDTOList;
    }

    @Override
    public List<AirlineCompanyEntity> dtoListToEntityList(List<AirlineCompanyDTO> airlineCompanyDTOS) {
        List<AirlineCompanyEntity> airlineCompanyEntityList = new ArrayList<>();
        for (AirlineCompanyDTO dto : airlineCompanyDTOS) {
            AirlineCompanyEntity entity = dtoToEntity(dto);
            airlineCompanyEntityList.add(entity);
        }
        return airlineCompanyEntityList;
    }

    @Override
    public AirlineCompanyEntity requestDTOToEntity(AirlineCompanyRequestDTO requestDTO) {
        AirlineCompanyEntity airlineCompanyEntity = new AirlineCompanyEntity();
        airlineCompanyEntity.setUuid(requestDTO.getUuid());
        airlineCompanyEntity.setCreationDate(requestDTO.getCreationDate());
        airlineCompanyEntity.setUpdatedDate(requestDTO.getUpdatedDate());
        airlineCompanyEntity.setId(requestDTO.getId());
        airlineCompanyEntity.setCompanyName(requestDTO.getCompanyName());
        airlineCompanyEntity.setPhoneNumber(requestDTO.getPhoneNumber());
        airlineCompanyEntity.setEmail(requestDTO.getEmail());
        airlineCompanyEntity.setFlight(flightMapper.requestDTOListToEntityList(requestDTO.getFlight()));
        if (requestDTO.getBankAccount() == null)
            airlineCompanyEntity.setBankAccount(null);
        else
            airlineCompanyEntity.setBankAccount(bankAccountMapper.requestDTOToEntity(requestDTO.getBankAccount()));

        return airlineCompanyEntity;
    }

    @Override
    public List<AirlineCompanyEntity> requestDTOListToEntityList(List<AirlineCompanyRequestDTO> requestDTOList) {
        List<AirlineCompanyEntity> airlineCompanyEntityList = new ArrayList<>();
        for (AirlineCompanyRequestDTO requestDTO : requestDTOList) {
            AirlineCompanyEntity entity = requestDTOToEntity(requestDTO);
            airlineCompanyEntityList.add(entity);
        }
        return airlineCompanyEntityList;
    }

    @Override
    public AirlineCompanyEntity requestDTOToExistEntity(AirlineCompanyRequestDTO requestDTO, AirlineCompanyEntity entity) {
        if (requestDTO.getCompanyName() != null)
            entity.setCompanyName(requestDTO.getCompanyName());
        if (requestDTO.getPhoneNumber() != null)
            entity.setPhoneNumber(requestDTO.getPhoneNumber());
        if (requestDTO.getEmail() != null)
            entity.setEmail(requestDTO.getEmail());
        if (requestDTO.getFlight() != null)
            entity.setFlight(flightMapper.requestDTOListToEntityList(requestDTO.getFlight()));
        if (requestDTO.getBankAccount() != null)
            entity.setBankAccount(bankAccountMapper.requestDTOToEntity(requestDTO.getBankAccount()));

        return entity;
    }

    @Override
    public Page<AirlineCompanyDTO> pageEntityToPageDTO(Page<AirlineCompanyEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
