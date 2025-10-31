package com.maryed.hotel_admin_system.pago.service;

import com.maryed.hotel_admin_system.pago.dto.PagoRequestDTO;
import com.maryed.hotel_admin_system.pago.dto.PagoResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface PagoService {
    List<PagoResponseDTO> listarPorReserva(Integer idReserva);
    List<PagoResponseDTO> listarPorEstado(String estadoPago);
    PagoResponseDTO obtenerPorId(Integer id);
    PagoResponseDTO registrar(PagoRequestDTO dto);
    PagoResponseDTO actualizar(Integer id, PagoRequestDTO dto);
    void eliminar(Integer id);
    BigDecimal calcularTotalPagadoPorReserva(Integer idReserva);
}
