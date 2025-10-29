package com.maryed.hotel_admin_system.acompanante.dao;

import com.maryed.hotel_admin_system.acompanante.model.Acompanante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcompananteDAO extends JpaRepository<Acompanante, Integer> {

    List<Acompanante> findByReservaIdReserva(Integer idReserva);
    Optional<Acompanante> findByDni(String dni);
}
