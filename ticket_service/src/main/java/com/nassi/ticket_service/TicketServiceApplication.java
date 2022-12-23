package com.nassi.ticket_service;

import com.nassi.ticket_service.Entities.Match;
import com.nassi.ticket_service.Entities.Ticket;
import com.nassi.ticket_service.Enums.Statut;
import com.nassi.ticket_service.Repos.MatchRepo;
import com.nassi.ticket_service.Repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TicketServiceApplication  {




    public static void main(String[] args) {
        SpringApplication.run(TicketServiceApplication.class, args);
    }

}

