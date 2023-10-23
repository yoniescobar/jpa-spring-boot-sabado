package com.company.intecap.agenciaviajes.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(length = 200) //tamaño maximo de la columna
    private UUID id; //UUID: Universally Unique Identifier consta de 32 caracteres

    private LocalDateTime departureDate; //formato: 2021-09-01 fecha de salida
    private LocalDateTime arrivalDate; // fecha de llegada
    private LocalDateTime purchaseDate; // fecha de compra
    private BigDecimal price;

    //ticket a fly(Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "fly_id") // para que se cree una columna en la tabla ticket con el nombre fly_id
    private FlyEntity fly; //ticket a fly(Muchos a uno)


    //ticket a customer(Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "customer_id") // para que se cree una columna en la tabla ticket con el nombre customer_id
    private CustomerEntity customer; //ticket a customer(Muchos a uno)

    //ticket a tour(Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "tour_id") // para que se cree una columna en la tabla ticket con el nombre tour_id
    private TourEntity tour; //ticket a tour(Muchos a uno)
}
