package com.maryed.hotel_admin_system.habitacion.dao;

import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionDAO extends JpaRepository<Habitacion, Integer> {
}
