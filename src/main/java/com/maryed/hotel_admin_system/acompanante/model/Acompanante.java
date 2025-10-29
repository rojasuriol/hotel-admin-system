package com.maryed.hotel_admin_system.acompanante.model;

import com.maryed.hotel_admin_system.reserva.model.Reserva;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ACOMPANANTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Acompanante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_acompanante")
    private Integer idAcompanante;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

}
