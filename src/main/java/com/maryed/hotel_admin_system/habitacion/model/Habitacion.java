package com.maryed.hotel_admin_system.habitacion.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalTime;

@Entity
@Table(name = "HABITACION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "id_hotel")
    private Integer idHotel;

    @Column(name = "numero_habitacion")
    private String numeroHabitacion;

    @Column(name = "tipo_habitacion")
    private String tipoHabitacion;

    @Column(name = "descripcion_habitacion")
    private String descripcionHabitacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tiempo_reservado")
    private LocalTime tiempoReservado;
}
