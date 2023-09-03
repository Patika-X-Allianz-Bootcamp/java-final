package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.Hospital;
import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.patienttourism.model.responseDTO.HospitalResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalService extends BaseService<Hospital, HospitalResponseDTO, HospitalRequestDTO> {


    public HospitalService(IBaseRepository<Hospital> repository, MapperService mapperService, BaseSpecification<Hospital> specification) {
        super(repository, mapperService, specification);
    }

    @Override
    protected Class<Hospital> getEntityClass() {
        return Hospital.class;
    }

    @Override
    protected Class<HospitalResponseDTO> getResponseDTOClass() {
        return HospitalResponseDTO.class;
    }
}
