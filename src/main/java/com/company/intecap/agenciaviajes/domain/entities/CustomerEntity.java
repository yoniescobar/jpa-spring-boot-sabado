package com.company.intecap.agenciaviajes.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;


@Entity(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(length = 20) //tamaño maximo de la columna
    private UUID dni; //UUID: Universally Unique Identifier consta de 32 caracteres

    @Column(length = 50)
    private String name;
    @Column(length = 20)
    private String creditCard;
    @Column(length = 20)
    private String phoneNumber;
    private Integer totalFlights; // total de vuelos
    private Integer totalLodgings; // total de alojamientos
    private Integer totalTours; // total de tours

    //uno a muchos Custumer a Reservation
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer" // el nombre del atributo en la clase ReservationEntity
    )
    private Set<ReservationEntity> reservations;


    //uno a muchos Custumer a Ticket
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer" // el nombre del atributo en la clase ReservationEntity
    )
    private Set<TicketEntity> tickets;

    //uno a muchos Custumer a Tour

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer" // el nombre del atributo en la clase ReservationEntity
    )
    private Set<TourEntity> tours;

}
