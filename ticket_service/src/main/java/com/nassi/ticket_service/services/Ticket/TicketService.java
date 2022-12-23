package com.nassi.ticket_service.services.Ticket;

import com.nassi.ticket_service.Dtos.requests.TicketrequestsDtos;
import com.nassi.ticket_service.Dtos.responses.TicketresponsesDtos;

public interface TicketService {
    TicketresponsesDtos buyTicket(TicketrequestsDtos ticketInputDto);

    void validateTicket(Long id);
}
