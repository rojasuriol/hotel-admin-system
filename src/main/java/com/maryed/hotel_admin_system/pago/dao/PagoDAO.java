package com.maryed.hotel_admin_system.pago.dao;

import com.maryed.hotel_admin_system.pago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoDAO extends JpaRepository<Pago, Integer> {
    List<Pago> findByReservaIdReserva(Integer idReserva);
    List<Pago> findByReservaIdReservaOrderByFechaPagoDesc(Integer idReserva);
    List<Pago> findByEstadoPago(String estadoPago);
}
