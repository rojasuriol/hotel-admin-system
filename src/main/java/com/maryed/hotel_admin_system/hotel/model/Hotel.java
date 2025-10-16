package com.maryed.hotel_admin_system.hotel.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "HOTEL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Integer idHotel;

    @Column(name = "nombre_hotel")
    private String nombreHotel;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;
}
