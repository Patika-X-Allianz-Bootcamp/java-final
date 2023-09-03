package com.patika.healthtourism.service;

import com.patika.healthtourism.database.entity.TravelPlanEntity;
import com.patika.healthtourism.database.repository.TravelPlanEntityRepository;
import com.patika.healthtourism.mapper.TravelPlanMapper;
import com.patika.healthtourism.model.TravelPlanDTO;
import com.patika.healthtourism.model.requestDTO.TravelPlanRequestDTO;
import com.patika.healthtourism.util.BaseService;
import com.patika.healthtourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class TravelPlanService extends BaseService<TravelPlanEntity, TravelPlanDTO, TravelPlanRequestDTO,
        TravelPlanMapper, TravelPlanEntityRepository> {
    private final TravelPlanMapper travelPlanMapper;
    private final TravelPlanEntityRepository travelPlanEntityRepository;

    public TravelPlanService(TravelPlanMapper travelPlanMapper, TravelPlanEntityRepository travelPlanEntityRepository) {
        this.travelPlanMapper = travelPlanMapper;
        this.travelPlanEntityRepository = travelPlanEntityRepository;
    }

    @Override
    protected TravelPlanMapper getMapper() {
        return travelPlanMapper;
    }

    @Override
    protected TravelPlanEntityRepository getRepository() {
        return travelPlanEntityRepository;
    }

    public void createTravelPlan(TravelPlanDTO travelPlan) {
        TravelPlanEntity travelPlan1 = getMapper().dtoToEntity(travelPlan);
         travelPlanEntityRepository.save(travelPlan1);
    }
}
