package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.acompanante.dto.AcompananteResponseDTO;
import com.maryed.hotel_admin_system.acompanante.service.AcompananteService;
import com.maryed.hotel_admin_system.cliente.dto.ClienteResponseDTO;
import com.maryed.hotel_admin_system.cliente.dto.ClientelRequestDTO;
import com.maryed.hotel_admin_system.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acompanante")
@RequiredArgsConstructor
public class AcompananteConsultasController {
    private final AcompananteService service;

    @GetMapping("/reserva/{idReserva}")
    public ResponseEntity<List<AcompananteResponseDTO>> listarPorReserva(@PathVariable(value = "idReserva") Integer idReserva) {
        List<AcompananteResponseDTO> acompanantes = service.listarPorReserva(idReserva);
        return ResponseEntity.ok(acompanantes);
    }
}