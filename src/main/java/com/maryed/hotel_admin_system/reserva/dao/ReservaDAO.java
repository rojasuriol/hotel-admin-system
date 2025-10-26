package com.maryed.hotel_admin_system.reserva.dao;

import com.maryed.hotel_admin_system.cliente.model.Cliente;
import com.maryed.hotel_admin_system.reserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaDAO extends JpaRepository<Reserva, Integer> {

    List<Reserva> findByClienteDni(String dni);
}
