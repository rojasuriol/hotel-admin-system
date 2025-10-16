package com.maryed.hotel_admin_system.habitacion.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionResponseDTO {

    private Integer idHabitacion;
    private Integer idHotel;
    private String numeroHabitacion;
    private String tipoHabitacion;
    private String descripcionHabitacion;
    private String estado;
    private LocalTime tiempoReservado;
}
