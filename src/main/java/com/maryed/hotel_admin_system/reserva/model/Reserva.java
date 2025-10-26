package com.maryed.hotel_admin_system.reserva.model;

import com.maryed.hotel_admin_system.cliente.model.Cliente;
import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import com.maryed.hotel_admin_system.hotel.model.Hotel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "RESERVA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idHabitacion")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotel;

    @Column(name = "fechaReserva")
    private LocalDate fechaReserva;

    @Column(name = "horaInicio")
    private LocalTime horaInicio;

    @Column(name = "horaFin")
    private LocalTime horaFin;

    @Column(name = "tiempoReservado")
    private LocalTime tiempoReservado;

    @Column(name = "estado")
    private String estado;
}
