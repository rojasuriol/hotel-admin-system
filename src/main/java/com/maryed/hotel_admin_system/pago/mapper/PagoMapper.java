package com.maryed.hotel_admin_system.pago.mapper;

import com.maryed.hotel_admin_system.pago.dto.PagoRequestDTO;
import com.maryed.hotel_admin_system.pago.dto.PagoResponseDTO;
import com.maryed.hotel_admin_system.pago.model.Pago;
import org.springframework.stereotype.Component;

@Component
public class PagoMapper {
    public Pago toEntity(PagoRequestDTO dto) {
        Pago entity = new Pago();
        entity.setMonto(dto.getMonto());
        entity.setMetodoPago(dto.getMetodoPago());
        entity.setEstadoPago(dto.getEstadoPago());
        return entity;
    }

    public PagoResponseDTO toDTO(Pago entity) {
        PagoResponseDTO dto = new PagoResponseDTO();
        dto.setIdPago(entity.getIdPago());
        dto.setIdReserva(entity.getReserva().getIdReserva());
        dto.setMonto(entity.getMonto());
        dto.setMetodoPago(entity.getMetodoPago());
        dto.setFechaPago(entity.getFechaPago());
        dto.setEstadoPago(entity.getEstadoPago());
        return dto;
    }
}