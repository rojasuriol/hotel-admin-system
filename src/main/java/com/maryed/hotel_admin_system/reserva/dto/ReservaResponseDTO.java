package com.maryed.hotel_admin_system.reserva.dto;

import com.maryed.hotel_admin_system.cliente.dto.ClienteResponseDTO;
import com.maryed.hotel_admin_system.cliente.model.Cliente;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;
import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.model.Hotel;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaResponseDTO {

    private Integer idReserva;
    private ClienteResponseDTO cliente;
    private HabitacionResponseDTO habitacion;
    private HotelResponseDTO hotel;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private String tipoReserva;
    private BigDecimal montoTotal;
    private String estadoReserva;
}
