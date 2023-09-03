package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.TestResultEntity;
import com.allianz.healthtourismagency.database.repository.TestResultRepository;
import com.allianz.healthtourismagency.database.specification.TestResultSpecification;
import com.allianz.healthtourismagency.mapper.TestResultMapper;
import com.allianz.healthtourismagency.model.TestResultDTO;
import com.allianz.healthtourismagency.model.requestDTO.TestResultRequestDTO;
import com.allianz.healthtourismagency.service.TestResultService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test-result")
public class TestResultController extends BaseController<
        TestResultEntity,
        TestResultDTO,
        TestResultRequestDTO,
        TestResultMapper,
        TestResultRepository,
        TestResultSpecification,
        TestResultService> {

    private final TestResultService testResultService;

    public TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @Override
    protected TestResultService getService() {
        return testResultService;
    }
}
