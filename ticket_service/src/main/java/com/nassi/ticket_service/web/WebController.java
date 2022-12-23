package com.nassi.ticket_service.web;

import com.nassi.ticket_service.Dtos.requests.MatchrequestsDtos;
import com.nassi.ticket_service.Dtos.requests.TicketrequestsDtos;
import com.nassi.ticket_service.Dtos.responses.MatchresponsesDtos;
import com.nassi.ticket_service.Dtos.responses.TicketresponsesDtos;
import com.nassi.ticket_service.services.Match.MatchService;
import com.nassi.ticket_service.services.Ticket.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {
    private MatchService matchService;
    private TicketService ticketService;

    @MutationMapping
    private MatchresponsesDtos ajouterMatch(@Argument MatchrequestsDtos gameInputDto) {
        return matchService.ajouterMatch(gameInputDto);
    }

    @QueryMapping
    private List<MatchresponsesDtos> getGames(){
        return matchService.gamesList();
    }


    @MutationMapping
    private TicketresponsesDtos getTicket(@Argument TicketrequestsDtos ticketInputDto) {
        return ticketService.buyTicket(ticketInputDto);
    }

    @MutationMapping
    private void updateTicket(@Argument Long id) {
        ticketService.validateTicket(id);
    }
}
