package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.habitacion.dto.HabitacionRequestDTO;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;
import com.maryed.hotel_admin_system.habitacion.service.HabitacionService;
import com.maryed.hotel_admin_system.hotel.dto.HotelRequestDTO;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/habitacion")
@RequiredArgsConstructor
public class HabitacionModificacionesController {
    private final HabitacionService service;

    @PostMapping("/crear")
    public ResponseEntity<String> registrar(@RequestBody HabitacionRequestDTO dto) {
        HabitacionResponseDTO habitacionCreada = service.registrar(dto);
        URI ubicacion = URI.create("/habitacion/crear" + habitacionCreada.getIdHabitacion());
        return ResponseEntity.created(ubicacion).body("Habitacion creado con exito. ");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody HabitacionRequestDTO dto) {

        service.actualizar(id, dto);
        return ResponseEntity.ok("Habitacion actualizado correctamente.");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok("Habitación eliminada correctamente.");
    }
}