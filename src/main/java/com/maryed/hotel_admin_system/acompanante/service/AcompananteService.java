package com.maryed.hotel_admin_system.acompanante.service;

import com.maryed.hotel_admin_system.acompanante.dto.AcompananteRequestDTO;
import com.maryed.hotel_admin_system.acompanante.dto.AcompananteResponseDTO;

import java.util.List;

public interface AcompananteService {
    List<AcompananteResponseDTO> listarPorReserva(Integer idReserva);
    AcompananteResponseDTO registrar(AcompananteRequestDTO dto);
    AcompananteResponseDTO actualizar(Integer id, AcompananteRequestDTO dto);
    void eliminar(Integer id);
}
