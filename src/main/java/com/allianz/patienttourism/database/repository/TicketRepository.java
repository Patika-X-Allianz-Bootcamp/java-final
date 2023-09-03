package com.allianz.patienttourism.database.repository;

import com.allianz.patienttourism.database.entity.Ticket;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends IBaseRepository<Ticket> {
}
