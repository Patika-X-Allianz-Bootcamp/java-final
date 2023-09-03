package com.allianz.HealthTourismSpringBoot.mapper;

import com.allianz.HealthTourismSpringBoot.database.entities.ClientEntity;
import com.allianz.HealthTourismSpringBoot.model.ClientDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.ClientRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper implements IBaseMapper<ClientEntity, ClientDTO, ClientRequestDTO> {

    @Autowired
    @Lazy
    AgencyMapper agencyMapper;

    @Override
    public ClientDTO entityToDTO(ClientEntity entity) {

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setUuid(entity.getUuid());
        clientDTO.setId(entity.getId());
        clientDTO.setCreationDate(entity.getCreationDate());
        clientDTO.setUpdatedDate(entity.getUpdatedDate());
        clientDTO.setName(entity.getName());
        clientDTO.setSurname(entity.getSurname());
        clientDTO.setCountry(entity.getCountry());
        clientDTO.setHealthCare(entity.getHealthCare());
        clientDTO.setAgency(agencyMapper.entityToDTO(entity.getAgency()));

        return clientDTO;
    }

    @Override
    public ClientEntity dtoToEntity(ClientDTO dto) {

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setUuid(dto.getUuid());
        clientEntity.setId(dto.getId());
        clientEntity.setCreationDate(dto.getCreationDate());
        clientEntity.setUpdatedDate(dto.getUpdatedDate());
        clientEntity.setName(dto.getName());
        clientEntity.setSurname(dto.getSurname());
        clientEntity.setCountry(dto.getCountry());
        clientEntity.setHealthCare(dto.getHealthCare());
        clientEntity.setAgency(agencyMapper.dtoToEntity(dto.getAgency()));

        return clientEntity;
    }

    @Override
    public List<ClientDTO> entityListToDTOList(List<ClientEntity> clientEntities) {

        List<ClientDTO> clientDTOList = new ArrayList<>();
        for (ClientEntity entity : clientEntities){
            clientDTOList.add(entityToDTO(entity));
        }

        return clientDTOList;
    }

    @Override
    public List<ClientEntity> dtoListToEntityList(List<ClientDTO> clientDTOS) {

        List<ClientEntity> clientEntityList = new ArrayList<>();
        for (ClientDTO dto : clientDTOS){
            clientEntityList.add(dtoToEntity(dto));
        }

        return clientEntityList;
    }

    @Override
    public ClientEntity requestDTOToEntity(ClientRequestDTO clientRequestDTO) {

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setUuid(clientRequestDTO.getUuid());
        clientEntity.setId(clientRequestDTO.getId());
        clientEntity.setCreationDate(clientRequestDTO.getCreationDate());
        clientEntity.setUpdatedDate(clientRequestDTO.getUpdatedDate());
        clientEntity.setName(clientRequestDTO.getName());
        clientEntity.setSurname(clientRequestDTO.getSurname());
        clientEntity.setCountry(clientRequestDTO.getCountry());
        clientEntity.setHealthCare(clientRequestDTO.getHealthCare());
        clientEntity.setAgency(agencyMapper.requestDTOToEntity(clientRequestDTO.getAgency()));

        return clientEntity;
    }

    @Override
    public List<ClientEntity> requestDTOListToEntityList(List<ClientRequestDTO> clientRequestDTOS) {

        List<ClientEntity> clientEntityList = new ArrayList<>();
        for (ClientRequestDTO dto : clientRequestDTOS){
            clientEntityList.add(requestDTOToEntity(dto));
        }

        return clientEntityList;
    }

    @Override
    public ClientEntity requestDTOToExistEntity(ClientRequestDTO clientRequestDTO, ClientEntity entity) {

        entity.setName(clientRequestDTO.getName());
        entity.setSurname(clientRequestDTO.getSurname());
        entity.setCountry(clientRequestDTO.getCountry());
        entity.setHealthCare(clientRequestDTO.getHealthCare());
        entity.setAgency(agencyMapper.requestDTOToEntity(clientRequestDTO.getAgency()));

        return entity;
    }

    @Override
    public Page<ClientDTO> pageEntityToPageDTO(Page<ClientEntity> clientEntities) {
        return clientEntities.map(this::entityToDTO);
    }
}
