package com.nassi.ticket_service.services.Ticket;

import com.nassi.ticket_service.Dtos.requests.TicketrequestsDtos;
import com.nassi.ticket_service.Dtos.responses.TicketresponsesDtos;
import com.nassi.ticket_service.Entities.Match;
import com.nassi.ticket_service.Entities.Ticket;
import com.nassi.ticket_service.Enums.Statut;
import com.nassi.ticket_service.Repos.MatchRepo;
import com.nassi.ticket_service.Repos.TicketRepo;
import com.nassi.ticket_service.mappers.MapperService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class TicketServiceImpl  implements TicketService {
    private MapperService mapperService;
    private MatchRepo matchRepository;
    private TicketRepo ticketRepository;

    @Override
    public TicketresponsesDtos buyTicket(TicketrequestsDtos ticketInputDto){
        if (ticketInputDto.getMatchId() == null ||
        ticketInputDto.getPrice().isNaN() || ticketInputDto.getPrice() <= 0)
        throw new RuntimeException("Field missing");
        Match match = matchRepository.findById(ticketInputDto.getMatchId())
                .orElseThrow(
                        () -> new RuntimeException("Id not found")
                );
        if (match.getNombreTickets() == 0)
            throw new RuntimeException("Ticket sold out");
        Ticket ticket = new Ticket();
        ticket.setPrice(ticketInputDto.getPrice());
        ticket.setStatut(Statut.ACTIVE);
        ticket.setRef(UUID.randomUUID().toString().substring(0,16));
        ticket.setMatch(match);

        match.setNombreTickets(match.getNombreTickets() - 1);
        matchRepository.save(match);
        return mapperService.fromTicket(ticketRepository.save(ticket));
    }

    @Override
    public void validateTicket(Long id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id Not Found"));
        if (ticket.getStatut() == Statut.DESACTIVE)
            throw new RuntimeException("Ticket deja valider");
        ticket.setStatut(Statut.DESACTIVE);
        ticketRepository.save(ticket);
    }
}
