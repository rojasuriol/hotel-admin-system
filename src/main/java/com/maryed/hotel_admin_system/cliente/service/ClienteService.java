package com.maryed.hotel_admin_system.cliente.service;

import com.maryed.hotel_admin_system.cliente.dto.ClientelRequestDTO;
import com.maryed.hotel_admin_system.cliente.dto.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteResponseDTO> listar(ClientelRequestDTO dto);
    ClienteResponseDTO obtenerPorId(Integer id);
    ClienteResponseDTO obtenerPorDni(String dni);
    ClienteResponseDTO registrar(ClientelRequestDTO dto);
    ClienteResponseDTO actualizar(Integer id, ClientelRequestDTO dto);
    void eliminar(Integer id);
}
