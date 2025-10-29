package com.maryed.hotel_admin_system.consumo.dao;

import com.maryed.hotel_admin_system.consumo.model.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumoDAO extends JpaRepository<Consumo, Integer> {
    List<Consumo> findByReservaIdReserva(Integer idReserva);
    List<Consumo> findByReservaIdReservaOrderByFechaConsumoDesc(Integer idReserva);
}
