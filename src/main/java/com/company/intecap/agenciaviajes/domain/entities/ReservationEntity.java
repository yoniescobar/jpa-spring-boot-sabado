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

@Entity(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(length = 200) //tamaño maximo de la columna
    private UUID id; //UUID: Universally Unique Identifier consta de 32 caracteres

    private LocalDateTime dateReservation; //fecha de reserva formato: 2021-09-01 10:00:00
    private LocalDateTime dateStart;//fecha de inicio
    private LocalDateTime dateEnd;//fecha de finalizacion
    private Integer totalDays;
    private BigDecimal price;

    //reservation a Hotel(Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;


    //reservation a customer(Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    //muchos a uno (reservation a Tour)
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

}
