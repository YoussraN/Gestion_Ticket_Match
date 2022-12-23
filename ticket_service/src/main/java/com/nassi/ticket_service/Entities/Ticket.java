package com.nassi.ticket_service.Entities;

import com.nassi.ticket_service.Enums.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 16,unique = true, nullable = false)
    private String ref;
    private double price;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    @ManyToOne
    private Match match;
}
