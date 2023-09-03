package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.ExaminationCardEntity;
import com.burakcanciftci.healthtourism.database.repository.ExaminationCardEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.ExaminationCardSpecification;
import com.burakcanciftci.healthtourism.mapper.ExaminationCardMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.ExaminationCardRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.ExaminationCardResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ExaminationCardService extends BaseService<ExaminationCardEntity, ExaminationCardResponseDTO, ExaminationCardRequestDTO> {

    private final ExaminationCardEntityRepository examinationCardEntityRepository;
    private final ExaminationCardMapper examinationCardMapper;
    private final ExaminationCardSpecification examinationCardSpecification;

    @Override
    protected ExaminationCardMapper getMapper() {
        return this.examinationCardMapper;
    }

    @Override
    protected ExaminationCardEntityRepository getRepository() {
        return this.examinationCardEntityRepository;
    }

    @Override
    protected ExaminationCardSpecification getSpecification() {
        return examinationCardSpecification;
    }
}