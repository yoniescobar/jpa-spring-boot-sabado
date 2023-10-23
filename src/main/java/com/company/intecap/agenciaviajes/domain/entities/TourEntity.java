package com.company.intecap.agenciaviajes.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "tour")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Muchos a uno (tour a Customer)
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerEntity customer;

    //Uno a muchos (tour a reservation)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "tour" // el nombre del atributo en la clase ReservationEntity

    )
    private Set<ReservationEntity> reservations;

    //Uno a muchos (tour a ticket)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "tour" // el nombre del atributo en la clase ReservationEntity

    )
    private Set<TicketEntity> tickets;
}
