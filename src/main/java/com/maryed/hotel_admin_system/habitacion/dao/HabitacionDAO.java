package com.maryed.hotel_admin_system.habitacion.dao;

import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionDAO extends JpaRepository<Habitacion, Integer> {
    List<Habitacion> findByHotelIdHotel(Integer idHotel);
}
