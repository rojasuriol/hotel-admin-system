package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.cliente.dto.ClienteResponseDTO;
import com.maryed.hotel_admin_system.cliente.dto.ClientelRequestDTO;
import com.maryed.hotel_admin_system.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteModificacionesController {
    private final ClienteService service;

    @PostMapping("/crear")
    public ClienteResponseDTO registrar(@RequestBody ClientelRequestDTO dto) {
        return service.registrar(dto);
    }

    @PutMapping("/actualizar/{id}")
    public ClienteResponseDTO actualizar(@PathVariable Integer id, @RequestBody ClientelRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}