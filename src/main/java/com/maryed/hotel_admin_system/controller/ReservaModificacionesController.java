package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.reserva.dto.ReservaRequestDTO;
import com.maryed.hotel_admin_system.reserva.dto.ReservaResponseDTO;
import com.maryed.hotel_admin_system.reserva.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaModificacionesController {
    private final ReservaService service;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO reservaCreado = service.registrar(dto);
        URI ubicacion = URI.create("/reserva/registrar" + reservaCreado.getIdReserva());
        return ResponseEntity.created(ubicacion).body("Reserva creada con exito.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(
            @PathVariable Integer id,
            @RequestBody ReservaRequestDTO dto) {

        service.actualizar(id, dto);
        return ResponseEntity.ok("Reserva actualizada correctamente.");
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok("Reserva eliminada correctamente.");
    }
}