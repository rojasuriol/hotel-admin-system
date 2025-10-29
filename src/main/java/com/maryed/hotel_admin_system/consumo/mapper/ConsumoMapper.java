package com.maryed.hotel_admin_system.consumo.mapper;

import com.maryed.hotel_admin_system.consumo.dto.ConsumoRequestDTO;
import com.maryed.hotel_admin_system.consumo.dto.ConsumoResponseDTO;
import com.maryed.hotel_admin_system.consumo.model.Consumo;
import org.springframework.stereotype.Component;

@Component
public class ConsumoMapper {
    public Consumo toEntity(ConsumoRequestDTO dto) {
        Consumo entity = new Consumo();
        entity.setProducto(dto.getProducto());
        entity.setCantidad(dto.getCantidad());
        entity.setPrecioUnitario(dto.getPrecioUnitario());
        return entity;
    }

    public ConsumoResponseDTO toDTO(Consumo entity) {
        ConsumoResponseDTO dto = new ConsumoResponseDTO();
        dto.setIdConsumo(entity.getIdConsumo());
        dto.setIdReserva(entity.getReserva().getIdReserva());
        dto.setProducto(entity.getProducto());
        dto.setCantidad(entity.getCantidad());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        dto.setFechaConsumo(entity.getFechaConsumo());
        dto.setSubtotal(entity.getSubtotal());
        return dto;
    }
}