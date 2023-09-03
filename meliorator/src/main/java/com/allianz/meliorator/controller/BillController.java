package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Bill;
import com.allianz.meliorator.database.repository.BillRepository;
import com.allianz.meliorator.mapper.BillMapper;
import com.allianz.meliorator.model.dto.BillDTO;
import com.allianz.meliorator.model.requestDTO.BillRequestDTO;
import com.allianz.meliorator.service.BillService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController extends BaseController<Bill, BillDTO, BillRequestDTO,
        BillMapper, BillRepository, BillService> {
    @Autowired
    BillService billService;
    @Override
    protected BillService getService() {
        return this.billService;
    }
}
