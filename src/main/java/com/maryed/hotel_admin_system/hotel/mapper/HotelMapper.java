package com.maryed.hotel_admin_system.hotel.mapper;

import com.maryed.hotel_admin_system.hotel.dto.HotelRequestDTO;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.model.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public Hotel toEntity(HotelRequestDTO dto) {
        return Hotel.builder()
                .nombreHotel(dto.getNombreHotel())
                .direccion(dto.getDireccion())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .build();
    }

    public HotelResponseDTO toDTO(Hotel entity) {
        return HotelResponseDTO.builder()
                .idHotel(entity.getIdHotel())
                .nombreHotel(entity.getNombreHotel())
                .direccion(entity.getDireccion())
                .telefono(entity.getTelefono())
                .email(entity.getEmail())
                .build();
    }
}
