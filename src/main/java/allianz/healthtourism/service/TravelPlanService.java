package allianz.healthtourism.service;

import allianz.healthtourism.base.BaseService;
import allianz.healthtourism.dto.Request.PatientRequest;
import allianz.healthtourism.dto.Request.TravelPlanRequest;
import allianz.healthtourism.dto.Response.PatientDTO;
import allianz.healthtourism.dto.Response.TravelPlanDTO;
import allianz.healthtourism.entity.Patient;
import allianz.healthtourism.entity.TravelPlan;
import allianz.healthtourism.mapper.ModelMapperManager;
import allianz.healthtourism.repository.PatientRepository;
import allianz.healthtourism.repository.TravelPlanRepository;
import allianz.healthtourism.specification.PatientSpecification;
import allianz.healthtourism.specification.TravelPlanSpecification;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelPlanService extends BaseService<TravelPlan, TravelPlanDTO, TravelPlanRequest, TravelPlanRepository, TravelPlanSpecification> {

    @Autowired
    TravelPlanRepository travelPlanRepository;

    @Autowired
    TravelPlanSpecification travelPlanSpecification;


    public TravelPlanService(ModelMapperManager modelMapperManager) {
        super(modelMapperManager);
    }

    @Override
    protected Class<TravelPlan> getEntity() {
        return TravelPlan.class;
    }

    @Override
    protected TravelPlanRepository getRepository() {
        return travelPlanRepository;
    }

    @Override
    protected TravelPlanSpecification getSpecification() {
        return travelPlanSpecification;
    }

    @Override
    protected Class<TravelPlanDTO> getDto() {
        return TravelPlanDTO.class;
    }

    @Override
    protected Class<TravelPlanRequest> getRequestDto() {
        return TravelPlanRequest.class;
    }


}
