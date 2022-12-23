package com.nassi.ticket_service.services.Match;

import com.nassi.ticket_service.Dtos.requests.MatchrequestsDtos;
import com.nassi.ticket_service.Dtos.responses.MatchresponsesDtos;

import java.util.List;

public interface MatchService {

    MatchresponsesDtos ajouterMatch(MatchrequestsDtos matchRequestDtos);

    List<MatchresponsesDtos> gamesList();
}
