package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.cliente.dto.ClienteResponseDTO;
import com.maryed.hotel_admin_system.cliente.dto.ClientelRequestDTO;
import com.maryed.hotel_admin_system.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteModificacionesController {
    private final ClienteService service;

    @PostMapping("/crear")
    public ResponseEntity<String> registrar(@RequestBody ClientelRequestDTO dto) {
        ClienteResponseDTO clienteResponseDTO = service.registrar(dto);
        URI ubicacion = URI.create("/cliente/crear" + clienteResponseDTO.getIdCliente());
        return ResponseEntity.created(ubicacion).body("Cliente creado con exito. ");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody ClientelRequestDTO dto) {
        service.actualizar(id, dto);
        return ResponseEntity.ok("Cliente actualizado correctamente.");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok("Cliente eliminada correctamente.");
    }
}