package com.maryed.hotel_admin_system.consumo.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsumoResponseDTO {

    private Integer idConsumo;
    private Integer idReserva;
    private String producto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private LocalDateTime fechaConsumo;
    private BigDecimal subtotal;
}
