package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.PlaneSeatEntity;
import com.burakcanciftci.healthtourism.database.repository.PlaneSeatEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.PlaneSeatSpecification;
import com.burakcanciftci.healthtourism.mapper.PlaneSeatMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.PlaneSeatRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.PlaneSeatResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class PlaneSeatService extends BaseService<PlaneSeatEntity, PlaneSeatResponseDTO, PlaneSeatRequestDTO> {

    private final PlaneSeatEntityRepository planeSeatEntityRepository;
    private final PlaneSeatMapper planeSeatMapper;
    private final PlaneSeatSpecification planeSeatSpecification;

    @Override
    protected PlaneSeatMapper getMapper() {
        return this.planeSeatMapper;
    }

    @Override
    protected PlaneSeatEntityRepository getRepository() {
        return this.planeSeatEntityRepository;
    }

    @Override
    protected PlaneSeatSpecification getSpecification() {
        return planeSeatSpecification;
    }

    public BigDecimal getPrice(UUID seatUuid){
        Optional<PlaneSeatEntity> planeSeatEntityOptional = planeSeatEntityRepository.findByUuid(seatUuid);

        if(planeSeatEntityOptional.isPresent()){
            return planeSeatEntityOptional.get().getTicketPrice();
        }

        // return negative value to notify that seat is not found
        return BigDecimal.valueOf(-1);
    }
}