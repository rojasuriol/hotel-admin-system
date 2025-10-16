package com.maryed.hotel_admin_system.hotel.service;

import com.maryed.hotel_admin_system.hotel.dto.HotelRequestDTO;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;

import java.util.List;

public interface HotelService {
    List<HotelResponseDTO> listar();
    HotelResponseDTO obtenerPorId(Integer id);
    HotelResponseDTO registrar(HotelRequestDTO dto);
    HotelResponseDTO actualizar(Integer id, HotelRequestDTO dto);
    void eliminar(Integer id);
}
