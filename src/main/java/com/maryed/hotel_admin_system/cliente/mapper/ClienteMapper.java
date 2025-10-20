package com.maryed.hotel_admin_system.cliente.mapper;

import com.maryed.hotel_admin_system.cliente.dto.ClientelRequestDTO;
import com.maryed.hotel_admin_system.cliente.dto.ClienteResponseDTO;
import com.maryed.hotel_admin_system.cliente.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClientelRequestDTO dto) {
        return Cliente.builder()
                .idCliente(dto.getIdCliente())
                .nombre(dto.getNombre())
                .apellidos(dto.getApellidos())
                .dni(dto.getDni())
                .tipoCliente(dto.getTipoCliente())
                .telefono(dto.getTelefono())
                .build();
    }

    public ClienteResponseDTO toDTO(Cliente entity) {
        return ClienteResponseDTO.builder()
                .idCliente(entity.getIdCliente())
                .nombre(entity.getNombre())
                .apellidos(entity.getApellidos())
                .dni(entity.getDni())
                .tipoCliente(entity.getTipoCliente())
                .telefono(entity.getTelefono())
                .build();
    }
}
