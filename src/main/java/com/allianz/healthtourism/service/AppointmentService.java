package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.repository.AppointmentRepository;
import com.allianz.healthtourism.database.specification.AppointmentSpecification;
import com.allianz.healthtourism.mapper.AppointmentMapper;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import com.allianz.healthtourism.util.pageable.BaseFilterRequestDTO;
import com.allianz.healthtourism.util.pageable.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AppointmentService extends BaseService<AppointmentResponseDTO, AppointmentRequestDTO, AppointmentEntity, AppointmentMapper, AppointmentRepository, AppointmentSpecification> {
    private final AppointmentRepository repository;
    private final AppointmentSpecification specification;
    @Override
    protected AppointmentMapper getMapper() {
        return AppointmentMapper.INSTANCE;
    }

    @Override
    protected AppointmentRepository getRepository() {
        return repository;
    }

    @Override
    protected AppointmentSpecification getSpecification() {
        return specification;
    }

    public AppointmentResponseDTO saveWithId(AppointmentRequestDTO requestDTO) {
        AppointmentEntity entity = getMapper().requestDtoToEntity(requestDTO);
        getRepository().save(entity);
        return getMapper().entityToResponseDto(entity);
    }
}
