package com.maryed.hotel_admin_system.habitacion.mapper;

import com.maryed.hotel_admin_system.habitacion.dto.HabitacionRequestDTO;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;

import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import org.springframework.stereotype.Component;

@Component
public class HabitacionMapper {

    public Habitacion toEntity(HabitacionRequestDTO dto) {
        return Habitacion.builder()
                .idHabitacion(dto.getIdHabitacion())
                .idHotel(dto.getIdHotel())
                .numeroHabitacion(dto.getNumeroHabitacion())
                .tipoHabitacion(dto.getTipoHabitacion())
                .descripcionHabitacion(dto.getDescripcionHabitacion())
                .estado(dto.getEstado())
                .tiempoReservado(dto.getTiempoReservado())
                .build();
    }

    public HabitacionResponseDTO toDTO(Habitacion entity) {
        return HabitacionResponseDTO.builder()
                .idHabitacion(entity.getIdHabitacion())
                .idHotel(entity.getIdHotel())
                .numeroHabitacion(entity.getNumeroHabitacion())
                .tipoHabitacion(entity.getTipoHabitacion())
                .descripcionHabitacion(entity.getDescripcionHabitacion())
                .estado(entity.getEstado())
                .tiempoReservado(entity.getTiempoReservado())
                .build();
    }
}
