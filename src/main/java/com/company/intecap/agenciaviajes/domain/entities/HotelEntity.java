package com.company.intecap.agenciaviajes.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String address;

    private int rating; // estrella del hotel
    private BigDecimal price;

    @ToString.Exclude //para que no se muestre en el toString
    @EqualsAndHashCode.Exclude //para que no se tenga en cuenta en el equals y hashcode
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "hotel"
    )
    private Set<ReservationEntity> reservations;
}
