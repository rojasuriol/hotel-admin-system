package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.reserva.dto.ReservaRequestDTO;
import com.maryed.hotel_admin_system.reserva.dto.ReservaResponseDTO;
import com.maryed.hotel_admin_system.reserva.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaConsultasController {
    private final ReservaService service;

    @PostMapping("/reservas")
    public ResponseEntity<List<ReservaResponseDTO>> listarPostGet(
            @RequestBody ReservaRequestDTO filtros) {
        List<ReservaResponseDTO> clientes = service.listar(filtros);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(clientes);
    }
}