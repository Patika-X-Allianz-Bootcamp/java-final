package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.DepartmentEntity;
import com.allianz.medicaltourismapp.database.repository.DepartmentEntityRepository;
import com.allianz.medicaltourismapp.database.repository.DepartmentEntityRepository;
import com.allianz.medicaltourismapp.database.specification.DepartmentSpecification;
import com.allianz.medicaltourismapp.database.specification.DepartmentSpecification;
import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.DepartmentMapper;
import com.allianz.medicaltourismapp.mapper.DepartmentMapper;
import com.allianz.medicaltourismapp.model.DepartmentDTO;
import com.allianz.medicaltourismapp.util.BaseService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DepartmentService extends BaseService<
        DepartmentDTO,
        DepartmentEntity,
        DepartmentEntityRepository,
        DepartmentMapper,
        DepartmentSpecification> {

    private final DepartmentEntityRepository departmentEntityRepository;


    private final DepartmentSpecification departmentSpecification;
    private final DepartmentMapper mapper;


    @Override
    protected DepartmentMapper getMapper() {
        return mapper;    }

    @Override
    protected DepartmentEntityRepository getRepository() {
        return departmentEntityRepository;
    }

    @Override
    protected DepartmentSpecification getSpecification() {
        return departmentSpecification;
    }
}
