package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.hotel.dto.HotelRequestDTO;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelModificacionesController {
    private final HotelService service;

    @PostMapping("/registrar")
    public HotelResponseDTO registrar(@RequestBody HotelRequestDTO dto) {
        return service.registrar(dto);
    }

    @PutMapping("/{id}")
    public HotelResponseDTO actualizar(@PathVariable Integer id, @RequestBody HotelRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}