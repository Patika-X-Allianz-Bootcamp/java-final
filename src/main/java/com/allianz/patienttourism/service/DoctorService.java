package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.Doctor;
import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.patienttourism.model.responseDTO.DoctorResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends BaseService<Doctor, DoctorResponseDTO, DoctorRequestDTO> {


    public DoctorService(IBaseRepository<Doctor> repository, MapperService mapperService, BaseSpecification<Doctor> specification) {
        super(repository, mapperService, specification);
    }

    @Override
    protected Class<Doctor> getEntityClass() {
        return Doctor.class;
    }

    @Override
    protected Class<DoctorResponseDTO> getResponseDTOClass() {
        return DoctorResponseDTO.class;
    }
}
