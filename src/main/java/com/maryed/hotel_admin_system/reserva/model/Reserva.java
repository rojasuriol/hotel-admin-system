package com.maryed.hotel_admin_system.reserva.model;

import com.maryed.hotel_admin_system.cliente.model.Cliente;
import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import com.maryed.hotel_admin_system.hotel.model.Hotel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "RESERVA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = true)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion", nullable = true)
    private Habitacion habitacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_hotel", referencedColumnName = "id_hotel", nullable = true)
    private Hotel hotel;

    @Column(name = "fecha_entrada", nullable = false)
    private LocalDateTime fechaEntrada;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(name = "tipo_reserva")
    private String tipoReserva; // "POR_HORAS" o "POR_DIAS"

    @Column(name = "monto_total")
    private Double montoTotal;

    @Column(name = "estado_reserva")
    private String estado; // "ACTIVA", "FINALIZADA", "CANCELADA"
}
