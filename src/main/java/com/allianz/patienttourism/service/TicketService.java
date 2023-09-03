package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.Ticket;
import com.allianz.patienttourism.service.rules.TicketServiceRules;
import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.TicketRequestDTO;
import com.allianz.patienttourism.model.responseDTO.TicketResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends BaseService<Ticket, TicketResponseDTO, TicketRequestDTO> {

    private TicketServiceRules ticketServiceRules;

    public TicketService(IBaseRepository<Ticket> repository, MapperService mapperService,
                         BaseSpecification<Ticket> specification, TicketServiceRules ticketServiceRules) {
        super(repository, mapperService, specification);
        this.ticketServiceRules = ticketServiceRules;
    }

    @Override
    protected Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    @Override
    protected Class<TicketResponseDTO> getResponseDTOClass() {
        return TicketResponseDTO.class;
    }

    @Override
    public TicketResponseDTO save(TicketRequestDTO requestDTO) {
        ticketServiceRules.checkIfSeatOccupied(requestDTO.getSeatId(),requestDTO.getTicketTime());
        ticketServiceRules.checkIfPatientOccupied(requestDTO.getPatientId(),requestDTO.getTicketTime());
        
        return super.save(requestDTO);
    }
}
