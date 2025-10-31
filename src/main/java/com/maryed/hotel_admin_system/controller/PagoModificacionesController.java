package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.hotel.dto.HotelRequestDTO;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.service.HotelService;
import com.maryed.hotel_admin_system.pago.dto.PagoRequestDTO;
import com.maryed.hotel_admin_system.pago.dto.PagoResponseDTO;
import com.maryed.hotel_admin_system.pago.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/pago")
@RequiredArgsConstructor
public class PagoModificacionesController {
    private final PagoService service;

    @PostMapping("/crear")
    public ResponseEntity<String> registrar(@RequestBody PagoRequestDTO dto) {
        PagoResponseDTO pagoResponse = service.registrar(dto);
        URI ubicacion = URI.create("/pago/crear" + pagoResponse.getIdPago());
        return ResponseEntity.created(ubicacion).body("Pago creado con éxito.");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody PagoRequestDTO dto) {
        service.actualizar(id, dto);
        return ResponseEntity.ok("Pago actualizado correctamente.");
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok("Pago eliminado correctamente.");
    }
}