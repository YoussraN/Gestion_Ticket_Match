package com.nassi.ticket_service.Dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketresponsesDtos {
    private Long id;
    private Double price;
    private String ref;
    private MatchresponsesDtos matchResponsesDtos;
}
