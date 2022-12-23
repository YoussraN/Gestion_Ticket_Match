package com.nassi.ticket_service.services.Match;

import com.nassi.ticket_service.Dtos.requests.MatchrequestsDtos;
import com.nassi.ticket_service.Dtos.responses.MatchresponsesDtos;
import com.nassi.ticket_service.Entities.Match;
import com.nassi.ticket_service.Repos.MatchRepo;
import com.nassi.ticket_service.mappers.MapperService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {
    private MatchRepo matchRepository;
    private MapperService mapperService;

    @Override
    public MatchresponsesDtos ajouterMatch(MatchrequestsDtos matchRequestDtos){
        if (matchRequestDtos.getDate() == null || matchRequestDtos.getNombreTickets() == null ||
        matchRequestDtos.getLieux()==null || matchRequestDtos.getLieux().isEmpty() ||
        matchRequestDtos.getEquipe1() == null || matchRequestDtos.getEquipe1().isEmpty() ||
        matchRequestDtos.getEquipe2() == null || matchRequestDtos.getEquipe2().isEmpty())
        throw new RuntimeException("Champs Manque");
        if (matchRequestDtos.getNombreTickets() > 2022  || matchRequestDtos.getNombreTickets() <= 0)
        throw new RuntimeException("Nombre de tickets no valide");
        Match match = new Match();
        match.setDate(matchRequestDtos.getDate());
        match.setLieux(matchRequestDtos.getLieux());
        match.setEquipe1(matchRequestDtos.getEquipe1());
        match.setEquipe2(matchRequestDtos.getEquipe2());
        match.setRef(UUID.randomUUID().toString());
        match.setNombreTickets(matchRequestDtos.getNombreTickets());
        Match savedMatch = matchRepository.save(match);
        return mapperService.fromMatch(savedMatch);
    }
    @Override
    public List<MatchresponsesDtos> gamesList(){
        return matchRepository.findAll().stream().map(
                g -> mapperService.fromMatch(g)
        ).toList();
    }
}
