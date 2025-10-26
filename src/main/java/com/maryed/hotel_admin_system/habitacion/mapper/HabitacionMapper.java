package com.maryed.hotel_admin_system.habitacion.mapper;

import com.maryed.hotel_admin_system.habitacion.dto.HabitacionRequestDTO;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;

import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import com.maryed.hotel_admin_system.hotel.model.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HabitacionMapper {

    public Habitacion toEntity(HabitacionRequestDTO dto) {
        Hotel hotel = new Hotel();
        hotel.setIdHotel(dto.getIdHotel());
        return Habitacion.builder()
                .idHabitacion(dto.getIdHabitacion())
                .hotel(hotel)
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
                .idHotel(entity.getHotel().getIdHotel())
                .numeroHabitacion(entity.getNumeroHabitacion())
                .tipoHabitacion(entity.getTipoHabitacion())
                .descripcionHabitacion(entity.getDescripcionHabitacion())
                .estado(entity.getEstado())
                .tiempoReservado(entity.getTiempoReservado())
                .build();
    }
}
