package com.maryed.hotel_admin_system.reserva.dto;

import com.maryed.hotel_admin_system.cliente.model.Cliente;
import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import com.maryed.hotel_admin_system.hotel.model.Hotel;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaRequestDTO {

    private Integer idReserva;

    private Cliente cliente;

    private Habitacion habitacion;

    private Hotel hotel;

    private LocalDate fechaReserva;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    private LocalTime tiempoReservado;

    private String estado;
}