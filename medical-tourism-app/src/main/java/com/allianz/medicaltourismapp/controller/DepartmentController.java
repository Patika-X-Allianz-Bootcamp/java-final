package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.DepartmentEntity;
import com.allianz.medicaltourismapp.database.repository.DepartmentEntityRepository;
import com.allianz.medicaltourismapp.database.specification.DepartmentSpecification;
import com.allianz.medicaltourismapp.mapper.DepartmentMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.DepartmentDTO;
import com.allianz.medicaltourismapp.service.DepartmentService;
import com.allianz.medicaltourismapp.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("department")
@RequiredArgsConstructor
public class DepartmentController extends BaseController<
        DepartmentEntity,
        DepartmentDTO,
        DepartmentMapper,
        DepartmentEntityRepository,
        DepartmentSpecification, DepartmentService
        > {

    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    protected DepartmentMapper getMapper() {
        return departmentMapper;
    }

    @Autowired
    DepartmentService departmentService;
    @Override
    protected DepartmentService getService() {
        return departmentService;
    }
}