package com.maryed.hotel_admin_system.acompanante.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcompananteResponseDTO {

    private Integer idAcompanante;
    private Integer idReserva;
    private String dni;
}
