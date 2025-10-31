package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.pago.dto.PagoResponseDTO;
import com.maryed.hotel_admin_system.pago.service.PagoService;
import com.maryed.hotel_admin_system.reserva.dto.ReservaRequestDTO;
import com.maryed.hotel_admin_system.reserva.dto.ReservaResponseDTO;
import com.maryed.hotel_admin_system.reserva.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pago")
@RequiredArgsConstructor
public class PagoConsultasController {
    private final PagoService service;

    @GetMapping("/reserva/{idReserva}")
    public ResponseEntity<List<PagoResponseDTO>> listarPorReserva(
            @PathVariable(value = "idReserva") Integer idReserva) {
        List<PagoResponseDTO> pagos = service.listarPorReserva(idReserva);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(pagos);
    }

    @GetMapping("/estado/{estado_pago}")
    public ResponseEntity<List<PagoResponseDTO>> listarPorEstado(
            @PathVariable(value = "estado_pago") String estadoPago) {
        List<PagoResponseDTO> pagos = service.listarPorEstado(estadoPago);
        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/{id}")
    public PagoResponseDTO obtener(@PathVariable(value = "id") Integer id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/total/{idReserva}")
    public ResponseEntity<BigDecimal> calcularTotalPagado(
            @PathVariable(value = "idReserva") Integer idReserva) {
        BigDecimal total = service.calcularTotalPagadoPorReserva(idReserva);
        return ResponseEntity.ok(total);
    }

}