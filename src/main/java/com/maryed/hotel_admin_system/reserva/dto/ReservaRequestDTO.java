package com.maryed.hotel_admin_system.reserva.dto;

import com.maryed.hotel_admin_system.cliente.model.Cliente;
import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
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
public class ReservaRequestDTO {

    private Integer idCliente;
    private Integer idHabitacion;
    private Integer idHotel;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private String tipoReserva;
    private BigDecimal montoTotal;
    private String DNICliente;
    private String estado;  // D = DISPONIBLE , O = OCUPADO  y M = MANTENIMIENTO

}