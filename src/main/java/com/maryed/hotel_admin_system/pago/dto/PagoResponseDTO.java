package com.maryed.hotel_admin_system.pago.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoResponseDTO {

    private Integer idPago;
    private Integer idReserva;
    private BigDecimal monto;
    private String metodoPago;
    private LocalDateTime fechaPago;
    private String estadoPago;
}
