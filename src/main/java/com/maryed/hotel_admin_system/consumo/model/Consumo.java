package com.maryed.hotel_admin_system.consumo.model;

import com.maryed.hotel_admin_system.reserva.model.Reserva;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CONSUMO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsumo;

    @ManyToOne
    @JoinColumn(name = "idReserva")
    private Reserva reserva;

    @Column(nullable = false)
    private String producto;

    private Integer cantidad = 1;

    @Column(precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fechaConsumo;

    @Column(precision = 10, scale = 2, insertable = false, updatable = false)
    private BigDecimal subtotal;
}