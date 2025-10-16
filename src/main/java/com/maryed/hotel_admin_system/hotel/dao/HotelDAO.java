package com.maryed.hotel_admin_system.hotel.dao;

import com.maryed.hotel_admin_system.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDAO extends JpaRepository<Hotel, Integer> {
}
