package com.nassi.ticket_service.Repos;

import com.nassi.ticket_service.Entities.Match;
import com.nassi.ticket_service.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepo extends JpaRepository<Match, Long> {
}
