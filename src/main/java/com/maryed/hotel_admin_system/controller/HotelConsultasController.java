package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelConsultasController {
    private final HotelService service;

    @GetMapping("/hoteles")
    public ResponseEntity<List<HotelResponseDTO>> listar() {
        List<HotelResponseDTO> hoteles = service.listar();
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(hoteles);
    }

    @GetMapping("/{id}")
    public HotelResponseDTO obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }
}
