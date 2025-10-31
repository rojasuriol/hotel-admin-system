package com.maryed.hotel_admin_system.pago.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoRequestDTO {

    private Integer idReserva;
    private BigDecimal monto;
    private String metodoPago;
    private String estadoPago;
}
