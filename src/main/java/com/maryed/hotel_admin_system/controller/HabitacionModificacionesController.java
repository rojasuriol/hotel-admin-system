package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.habitacion.dto.HabitacionRequestDTO;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;
import com.maryed.hotel_admin_system.habitacion.service.HabitacionService;
import com.maryed.hotel_admin_system.hotel.dto.HotelRequestDTO;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habitacion")
@RequiredArgsConstructor
public class HabitacionModificacionesController {
    private final HabitacionService service;

    @PostMapping("/crear")
    public HabitacionResponseDTO registrar(@RequestBody HabitacionRequestDTO dto) {
        return service.registrar(dto);
    }

    @PutMapping("/actualizar/{id}")
    public HabitacionResponseDTO actualizar(@PathVariable Integer id, @RequestBody HabitacionRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}