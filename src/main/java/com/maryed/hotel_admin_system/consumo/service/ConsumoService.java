package com.maryed.hotel_admin_system.consumo.service;

import com.maryed.hotel_admin_system.consumo.dto.ConsumoRequestDTO;
import com.maryed.hotel_admin_system.consumo.dto.ConsumoResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ConsumoService {
    List<ConsumoResponseDTO> listarPorReserva(Integer idReserva);
    ConsumoResponseDTO obtenerPorId(Integer id);
    ConsumoResponseDTO registrar(ConsumoRequestDTO dto);
    ConsumoResponseDTO actualizar(Integer id, ConsumoRequestDTO dto);
    void eliminar(Integer id);
    BigDecimal calcularTotalConsumosPorReserva(Integer idReserva);
}
