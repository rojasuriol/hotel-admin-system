package com.maryed.hotel_admin_system.reserva.service;

import com.maryed.hotel_admin_system.reserva.dto.ReservaRequestDTO;
import com.maryed.hotel_admin_system.reserva.dto.ReservaResponseDTO;

import java.util.List;

public interface ReservaService {
    List<ReservaResponseDTO> listar(ReservaRequestDTO dto);

    ReservaResponseDTO registrar(ReservaRequestDTO dto);

    ReservaResponseDTO actualizar(Integer id, ReservaRequestDTO dto);

    void eliminar(Integer id);
}
