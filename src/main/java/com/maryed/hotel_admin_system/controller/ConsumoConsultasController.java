package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.acompanante.dto.AcompananteResponseDTO;
import com.maryed.hotel_admin_system.acompanante.service.AcompananteService;
import com.maryed.hotel_admin_system.consumo.dto.ConsumoResponseDTO;
import com.maryed.hotel_admin_system.consumo.service.ConsumoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/consumo")
@RequiredArgsConstructor
public class ConsumoConsultasController {
    private final ConsumoService service;

    @GetMapping("/reserva/{idReserva}")
    public ResponseEntity<List<ConsumoResponseDTO>> listarPorReserva(
            @PathVariable(value = "idReserva") Integer idReserva) {
        List<ConsumoResponseDTO> consumos = service.listarPorReserva(idReserva);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(consumos);
    }

    @GetMapping("/{id}")
    public ConsumoResponseDTO obtener(@PathVariable(value = "id") Integer id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/total/{idReserva}")
    public ResponseEntity<BigDecimal> calcularTotalConsumos(
            @PathVariable(value = "idReserva") Integer idReserva) {
        BigDecimal total = service.calcularTotalConsumosPorReserva(idReserva);
        return ResponseEntity.ok(total);
    }
}