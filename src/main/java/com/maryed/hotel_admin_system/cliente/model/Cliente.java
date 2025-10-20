package com.maryed.hotel_admin_system.cliente.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "dni")
    private String dni;

    @Column(name = "tipo_cliente")
    private String tipoCliente;

    @Column(name = "telefono")
    private String telefono;
}
