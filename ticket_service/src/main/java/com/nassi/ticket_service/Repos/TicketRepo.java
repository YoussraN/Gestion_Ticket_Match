package com.nassi.ticket_service.Repos;

import com.nassi.ticket_service.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
