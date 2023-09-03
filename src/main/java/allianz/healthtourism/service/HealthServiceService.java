package allianz.healthtourism.service;

import allianz.healthtourism.base.BaseService;
import allianz.healthtourism.dto.Request.HealthServiceRequest;
import allianz.healthtourism.dto.Response.HealthServiceDTO;
import allianz.healthtourism.entity.HealthService;
import allianz.healthtourism.mapper.ModelMapperManager;
import allianz.healthtourism.repository.HealthServiceRepository;
import allianz.healthtourism.specification.HealthServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceService extends BaseService<HealthService, HealthServiceDTO, HealthServiceRequest, HealthServiceRepository, HealthServiceSpecification> {

    @Autowired
    HealthServiceRepository healthServiceRepository;

    @Autowired
    HealthServiceSpecification healthServiceSpecification;


    public HealthServiceService(ModelMapperManager modelMapperManager) {
        super(modelMapperManager);
    }

    @Override
    protected Class<HealthService> getEntity() {
        return HealthService.class;
    }

    @Override
    protected HealthServiceRepository getRepository() {
        return healthServiceRepository;
    }

    @Override
    protected HealthServiceSpecification getSpecification() {
        return healthServiceSpecification;
    }

    @Override
    protected Class<HealthServiceDTO> getDto() {
        return HealthServiceDTO.class;
    }

    @Override
    protected Class<HealthServiceRequest> getRequestDto() {
        return HealthServiceRequest.class;
    }}
