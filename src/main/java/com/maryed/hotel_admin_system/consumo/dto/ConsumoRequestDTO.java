package com.maryed.hotel_admin_system.consumo.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsumoRequestDTO {

    private Integer idReserva;
    private String producto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
}
