package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.Ticket;
import com.allianz.patienttourism.model.requestDTO.TicketRequestDTO;
import com.allianz.patienttourism.model.responseDTO.TicketResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController extends BaseController<Ticket, TicketResponseDTO, TicketRequestDTO> {
    public TicketController(BaseService<Ticket, TicketResponseDTO, TicketRequestDTO> service) {
        super(service);
    }
}
