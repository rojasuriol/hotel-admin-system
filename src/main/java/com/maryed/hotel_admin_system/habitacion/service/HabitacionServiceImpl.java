package com.maryed.hotel_admin_system.habitacion.service;


import com.maryed.hotel_admin_system.habitacion.dao.HabitacionDAO;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionRequestDTO;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;
import com.maryed.hotel_admin_system.habitacion.mapper.HabitacionMapper;

import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HabitacionServiceImpl implements HabitacionService {
    private final HabitacionDAO repository;
    private final HabitacionMapper mapper;

    @Override
    public List<HabitacionResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public HabitacionResponseDTO obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));
    }

    @Override
    public HabitacionResponseDTO registrar(HabitacionRequestDTO dto) {
        Habitacion entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public HabitacionResponseDTO actualizar(Integer id, HabitacionRequestDTO dto) {
        Habitacion habitacion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));

        habitacion.setIdHotel(dto.getIdHotel());
        habitacion.setNumeroHabitacion(dto.getNumeroHabitacion());
        habitacion.setTipoHabitacion(dto.getTipoHabitacion());
        habitacion.setDescripcionHabitacion(dto.getDescripcionHabitacion());
        habitacion.setEstado(dto.getEstado());
        habitacion.setTiempoReservado(dto.getTiempoReservado());
        return mapper.toDTO(repository.save(habitacion));
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}