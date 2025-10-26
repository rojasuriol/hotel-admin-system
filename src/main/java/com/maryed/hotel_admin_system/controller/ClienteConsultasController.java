package com.maryed.hotel_admin_system.controller;

import com.maryed.hotel_admin_system.cliente.dto.ClienteResponseDTO;
import com.maryed.hotel_admin_system.cliente.dto.ClientelRequestDTO;
import com.maryed.hotel_admin_system.cliente.service.ClienteService;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;
import com.maryed.hotel_admin_system.habitacion.service.HabitacionService;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteConsultasController {
    private final ClienteService service;

    @PostMapping("/clientes")
    public ResponseEntity<List<ClienteResponseDTO>> listarPostGet(
            @RequestBody ClientelRequestDTO filtros) {
        List<ClienteResponseDTO> clientes = service.listar(filtros);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(clientes);
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO obtener(@PathVariable(value = "id") Integer id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/dni/{dni_cliente}")
    public ClienteResponseDTO obtenerPorDni(@PathVariable(value = "dni_cliente") String dni) {
        return  service.obtenerPorDni(dni);
    }
}