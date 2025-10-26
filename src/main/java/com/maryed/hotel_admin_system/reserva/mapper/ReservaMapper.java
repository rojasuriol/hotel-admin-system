package com.maryed.hotel_admin_system.reserva.mapper;

import com.maryed.hotel_admin_system.reserva.dto.ReservaRequestDTO;
import com.maryed.hotel_admin_system.reserva.dto.ReservaResponseDTO;
import com.maryed.hotel_admin_system.reserva.model.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    public Reserva toEntity(ReservaRequestDTO dto) {
        return Reserva.builder()
                .idReserva(dto.getIdReserva())
                .cliente(dto.getCliente())
                .habitacion(dto.getHabitacion())
                .hotel(dto.getHotel())
                .fechaReserva(dto.getFechaReserva())
                .horaInicio(dto.getHoraFin())
                .tiempoReservado(dto.getTiempoReservado())
                .estado(dto.getEstado())
                .build();
    }

    public ReservaResponseDTO toDTO(Reserva entity) {
        return ReservaResponseDTO.builder()
                .idReserva(entity.getIdReserva())
                .cliente(entity.getCliente())
                .habitacion(entity.getHabitacion())
                .hotel(entity.getHotel())
                .fechaReserva(entity.getFechaReserva())
                .horaInicio(entity.getHoraFin())
                .tiempoReservado(entity.getTiempoReservado())
                .estado(entity.getEstado())
                .build();
    }
}
