package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Bill;
import com.allianz.meliorator.model.dto.BillDTO;
import com.allianz.meliorator.model.requestDTO.BillRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper extends IBaseMapper<Bill, BillDTO, BillRequestDTO> {
}
