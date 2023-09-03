package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.SalaryEntity;
import com.burakcanciftci.healthtourism.database.repository.SalaryEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.SalarySpecification;
import com.burakcanciftci.healthtourism.mapper.SalaryMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.SalaryRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.SalaryResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SalaryService extends BaseService<SalaryEntity, SalaryResponseDTO, SalaryRequestDTO> {

    private final SalaryEntityRepository salaryEntityRepository;
    private final SalaryMapper salaryMapper;
    private final SalarySpecification salarySpecification;

    @Override
    protected SalaryMapper getMapper() {
        return this.salaryMapper;
    }

    @Override
    protected SalaryEntityRepository getRepository() {
        return this.salaryEntityRepository;
    }

    @Override
    protected SalarySpecification getSpecification() {
        return salarySpecification;
    }
}