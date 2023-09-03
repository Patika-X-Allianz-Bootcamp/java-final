package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.TestResultEntity;
import com.allianz.healthtourismagency.database.repository.TestResultRepository;
import com.allianz.healthtourismagency.database.specification.TestResultSpecification;
import com.allianz.healthtourismagency.mapper.TestResultMapper;
import com.allianz.healthtourismagency.model.TestResultDTO;
import com.allianz.healthtourismagency.model.requestDTO.TestResultRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TestResultService extends BaseService<TestResultEntity, TestResultDTO, TestResultRequestDTO,
        TestResultMapper, TestResultRepository, TestResultSpecification> {

    private final TestResultMapper testResultMapper;
    private final TestResultRepository testResultRepository;
    private final TestResultSpecification testResultSpecification;

    public TestResultService(TestResultMapper testResultMapper, TestResultRepository testResultRepository,
                             TestResultSpecification testResultSpecification) {
        this.testResultMapper = testResultMapper;
        this.testResultRepository = testResultRepository;
        this.testResultSpecification = testResultSpecification;
    }


    @Override
    protected TestResultMapper getMapper() {
        return testResultMapper;
    }

    @Override
    protected TestResultRepository getRepository() {
        return testResultRepository;
    }

    @Override
    protected TestResultSpecification getSpecification() {
        return testResultSpecification;
    }
}
