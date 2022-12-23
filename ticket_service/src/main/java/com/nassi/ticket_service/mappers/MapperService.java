package com.nassi.ticket_service.mappers;

import com.nassi.ticket_service.Dtos.responses.MatchresponsesDtos;
import com.nassi.ticket_service.Dtos.responses.TicketresponsesDtos;
import com.nassi.ticket_service.Entities.Match;
import com.nassi.ticket_service.Entities.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public MatchresponsesDtos fromMatch(Match math){
        MatchresponsesDtos matchResponsesDtos = new MatchresponsesDtos();
        BeanUtils.copyProperties(math, matchResponsesDtos);
        return  matchResponsesDtos;
    }

    public TicketresponsesDtos fromTicket(Ticket ticket){
        TicketresponsesDtos ticketResponseDto = new TicketresponsesDtos();
        BeanUtils.copyProperties(ticket, ticketResponseDto);
        ticketResponseDto.setMatchResponsesDtos(fromMatch(ticket.getMatch()));
        return ticketResponseDto;
    }
}
