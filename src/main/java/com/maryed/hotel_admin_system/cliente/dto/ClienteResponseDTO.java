package com.maryed.hotel_admin_system.cliente.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteResponseDTO {
    private Integer idCliente;

    private String nombre;

    private String apellidos;

    private String dni;

    private String tipoCliente;

    private String telefono;

}
