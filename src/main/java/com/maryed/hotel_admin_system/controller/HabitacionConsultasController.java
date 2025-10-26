package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;
import com.maryed.hotel_admin_system.habitacion.service.HabitacionService;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/habitacion")
@RequiredArgsConstructor
public class HabitacionConsultasController {
    private final HabitacionService service;

    @GetMapping("/habitaciones/{id_hotel}")
    public List<HabitacionResponseDTO> listar(@PathVariable (required = false, value = "id_hotel") Integer idHotel) {
        return service.listar(idHotel);
    }

    @GetMapping("/{id}")
    public HabitacionResponseDTO obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }
}