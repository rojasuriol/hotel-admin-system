package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.hotel.dto.HotelRequestDTO;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelModificacionesController {
    private final HotelService service;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody HotelRequestDTO dto) {
        HotelResponseDTO hotelCreado = service.registrar(dto);
        URI ubicacion = URI.create("/hoteles/registrar" + hotelCreado.getIdHotel());
        return ResponseEntity.created(ubicacion).body("Hotel creado con exito. ");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(
            @PathVariable Integer id,
            @RequestBody HotelRequestDTO dto) {

        service.actualizar(id, dto);
        return ResponseEntity.ok("Hotel actualizado correctamente.");
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok("Hotel eliminada correctamente.");
    }
}