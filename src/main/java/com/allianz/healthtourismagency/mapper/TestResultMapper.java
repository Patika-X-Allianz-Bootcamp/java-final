package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.TestResultEntity;
import com.allianz.healthtourismagency.model.TestResultDTO;
import com.allianz.healthtourismagency.model.requestDTO.TestResultRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestResultMapper extends IBaseMapper<TestResultEntity, TestResultDTO, TestResultRequestDTO> {

}
