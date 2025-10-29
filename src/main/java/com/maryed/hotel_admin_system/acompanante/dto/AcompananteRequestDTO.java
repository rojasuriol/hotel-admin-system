package com.maryed.hotel_admin_system.acompanante.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcompananteRequestDTO {

    private Integer idReserva;
    private String dni;
}
