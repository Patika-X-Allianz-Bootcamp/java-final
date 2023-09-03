package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.PlaneEntity;
import com.burakcanciftci.healthtourism.database.repository.PlaneEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.PlaneSpecification;
import com.burakcanciftci.healthtourism.mapper.PlaneMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.PlaneRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.PlaneResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PlaneService extends BaseService<PlaneEntity, PlaneResponseDTO, PlaneRequestDTO> {

    private final PlaneEntityRepository planeEntityRepository;
    private final PlaneMapper planeMapper;
    private final PlaneSpecification planeSpecification;

    @Override
    protected PlaneMapper getMapper() {
        return this.planeMapper;
    }

    @Override
    protected PlaneEntityRepository getRepository() {
        return this.planeEntityRepository;
    }

    @Override
    protected PlaneSpecification getSpecification() {
        return planeSpecification;
    }
}