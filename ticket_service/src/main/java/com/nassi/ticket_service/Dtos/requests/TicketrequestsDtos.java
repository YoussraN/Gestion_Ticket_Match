package com.nassi.ticket_service.Dtos.requests;

import com.nassi.ticket_service.Dtos.responses.MatchresponsesDtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketrequestsDtos {
    private Double price;
    private Long MatchId;
}
