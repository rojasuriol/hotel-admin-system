package com.maryed.hotel_admin_system.habitacion.service;

import com.maryed.hotel_admin_system.habitacion.dto.HabitacionRequestDTO;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;

import java.util.List;

public interface HabitacionService {
    List<HabitacionResponseDTO> listar(Integer idHotel);
    HabitacionResponseDTO obtenerPorId(Integer id);
    HabitacionResponseDTO registrar(HabitacionRequestDTO dto);
    HabitacionResponseDTO actualizar(Integer id, HabitacionRequestDTO dto);
    void eliminar(Integer id);
}
