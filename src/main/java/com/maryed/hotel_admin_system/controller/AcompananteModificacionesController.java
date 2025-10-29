package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.acompanante.dto.AcompananteRequestDTO;
import com.maryed.hotel_admin_system.acompanante.dto.AcompananteResponseDTO;
import com.maryed.hotel_admin_system.acompanante.service.AcompananteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/acompanante")
@RequiredArgsConstructor
public class AcompananteModificacionesController {
    private final AcompananteService service;

    @PostMapping("/crear")
    public ResponseEntity<String> registrar(@RequestBody AcompananteRequestDTO dto) {
        AcompananteResponseDTO response = service.registrar(dto);
        URI ubicacion = URI.create("/acompanante/" + response.getIdAcompanante());
        return ResponseEntity.created(ubicacion).body("Acompañante creado con éxito.");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody AcompananteRequestDTO dto) {
        service.actualizar(id, dto);
        return ResponseEntity.ok("Acompañante actualizado correctamente.");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok("Acompañante eliminado correctamente.");
    }
}