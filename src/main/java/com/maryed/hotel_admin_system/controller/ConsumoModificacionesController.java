package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.consumo.dto.ConsumoRequestDTO;
import com.maryed.hotel_admin_system.consumo.dto.ConsumoResponseDTO;
import com.maryed.hotel_admin_system.consumo.service.ConsumoService;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;
import com.maryed.hotel_admin_system.habitacion.service.HabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/consumo")
@RequiredArgsConstructor
public class ConsumoModificacionesController {
    private final ConsumoService service;

    @PostMapping("/crear")
    public ResponseEntity<String> registrar(@RequestBody ConsumoRequestDTO dto) {
        ConsumoResponseDTO consumoResponse = service.registrar(dto);
        URI ubicacion = URI.create("/consumo/crear" + consumoResponse.getIdConsumo());
        return ResponseEntity.created(ubicacion).body("Consumo creado con éxito.");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody ConsumoRequestDTO dto) {
        service.actualizar(id, dto);
        return ResponseEntity.ok("Consumo actualizado correctamente.");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok("Consumo eliminado correctamente.");
    }
}