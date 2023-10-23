package com.company.intecap.agenciaviajes.domain.entities;

import com.company.intecap.agenciaviajes.utils.AeroLine;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "fly")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double originLat; //latitud de origen
    private Double originLng; //longitud de origen
    private Double destinyLng; //longitud de destino
    private Double destinyLat; //latitud de destino
    @Column(length = 20)
    private String originName; //nombre de origen
    @Column(length = 20)
    private String destinyName; //nombre de destino
    @Enumerated(EnumType.STRING)                            //Enumerable es un tipo de dato que se puede convertir a string
    private AeroLine aeroLine; //aerolinea
    private Double price; //precio

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL, // si se elimina un vuelo se eliminan todos los tickets relacionados
            fetch = FetchType.EAGER, // para que se carguen todos los tickets relacionados con un vuelo
            orphanRemoval = true, // para que se eliminen los tickets que no esten relacionados con un vuelo
            mappedBy = "fly" // para indicar que el atributo fly de la clase TicketEntity es el que tiene la relacion
    )

    private Set<TicketEntity> tickets;

}
